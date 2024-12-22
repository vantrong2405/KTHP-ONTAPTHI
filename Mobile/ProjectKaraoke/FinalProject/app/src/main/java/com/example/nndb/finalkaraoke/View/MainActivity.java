package com.example.nndb.finalkaraoke.View;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nndb.finalkaraoke.Model.Adapter.AdapterMusic;
import com.example.nndb.finalkaraoke.Model.Adapter.YoutubeAdapter;
import com.example.nndb.finalkaraoke.Model.Adapter.YoutubeConnector;
import com.example.nndb.finalkaraoke.Model.DTO.Music;
import com.example.nndb.finalkaraoke.Model.DTO.VideoItem;
import com.example.nndb.finalkaraoke.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    //region Import Database
    public  static String DATABASE_NAME="Arirang.sqlite";
    String DB_PATH_SUFFIX="/databases/";
    public  static SQLiteDatabase database=null;

    private void xuLySaoChepCSDL() {

        File dbFile=getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists())
        {
            try
            {
                CopyDataBaseFromAssset();
                Toast.makeText(this,"Sao chép thành công!!",Toast.LENGTH_LONG).show();
            }
            catch (Exception ex)
            {
                Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }

    private void CopyDataBaseFromAssset() {
        try
        {
            InputStream myInput= getAssets().open(DATABASE_NAME);
            String outFileName=layDuongDanLuuTru();
            File f=new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists())
            {
                f.mkdir();
            }
            OutputStream myOutput=new FileOutputStream(outFileName);
            byte[] buffer=new byte[1024];
            int lenght;
            while ((lenght=myInput.read(buffer))>0)
            {
                myOutput.write(buffer,0,lenght);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }
        catch (Exception ex)
        {
            Log.e("Loi_SaoChep",ex.toString());
        }
    }

    private String layDuongDanLuuTru()
    {
        return  getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;
    }
    //endregion;

    //region Value
    ListView lvBaiHat;
    ListView lvYeuThich;
    ArrayList<Music> dsBaiHat;
    AdapterMusic adapterBaiHat;
    ArrayList<Music> dsYeuThich;
    AdapterMusic adapterYeuThich;
    TabHost tabHost;
    ImageButton btnLike,btnDislike;
    TextView tvTenBH;
    EditText txtTimBH,txtTimYT;
    Button btnTimBH,btnTimYT;

    EditText txtSearch;
    Button btnTimBHOnline;
    RecyclerView recycleViewYoutubeSearch;

    YoutubeAdapter youtubeAdapter;
    List<VideoItem> searchResults;
    Handler handler;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xuLySaoChepCSDL();
        addControls();
        addEvents();
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);

        Boolean firstStart = pref.getBoolean("firstStart",true);
        if (firstStart) {
            //show start activity
            showIntro();
        }

    }



    private void addEvents() {


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equalsIgnoreCase("t1"))
                {
                    xuLyHienThiBaiHat();
                }
                else
                {
                    xuLyHienThiYeuThich();
                }
            }
        });

        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music musicYoutube=adapterBaiHat.getItem(position);
                final Intent intent=new Intent(MainActivity.this,MainYoutube.class);
                intent.putExtra("KEY_MUSIC",musicYoutube);
                startActivity(intent);
            }
        });

        lvYeuThich.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music musicYoutube=adapterBaiHat.getItem(position);
                final Intent intent=new Intent(MainActivity.this,MainYoutube.class);
                intent.putExtra("KEY_MUSIC",musicYoutube);
                startActivity(intent);
            }
        });

        btnTimBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBH();

            }
        });
        btnTimYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchYT();
            }
        });
        btnTimBHOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchOnYoutube(txtSearch.getText().toString()+" karaoke");
            }
        });
    }



    //region Search
    private void searchBH() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.rawQuery("SELECT * FROM ArirangSongList where TENBH LIKE '%"+txtTimBH.getText().toString()+"%'",null);
        dsBaiHat.clear();
        while (cursor.moveToNext())
        {
            String MaBH=cursor.getString(0);
            String TenBH=cursor.getString(1);
            String CaSi=cursor.getString(3);
            int YeuThich=cursor.getInt(5);
            String KeyYoutube=cursor.getString(6);

            Music music=new Music();
            music.setMaBH(MaBH);
            music.setTenBH(TenBH);
            music.setCaSi(CaSi);
            music.setYeuThich(YeuThich==1);
            music.setKeyYoutube(KeyYoutube);
            dsBaiHat.add(music);
        }
        cursor.close();
        adapterBaiHat.notifyDataSetChanged();
    }

    private void searchYT() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList  where YEUTHICH=1 AND TENBH LIKE '%"+txtTimYT.getText().toString()+"%'",null);
        dsYeuThich.clear();
        while (cursor.moveToNext())
        {
            String MaBH=cursor.getString(0);
            String TenBH=cursor.getString(1);
            String CaSi=cursor.getString(3);
            int YeuThich=cursor.getInt(5);
            String KeyYoutube=cursor.getString(6);

            Music music=new Music();
            music.setMaBH(MaBH);
            music.setTenBH(TenBH);
            music.setCaSi(CaSi);
            music.setYeuThich(YeuThich==0);
            music.setKeyYoutube(KeyYoutube);
            dsYeuThich.add(music);
        }
        cursor.close();
        adapterYeuThich.notifyDataSetChanged();

    }

    //endregion;


    //region Xử lý hiển thị
    private void xuLyHienThiYeuThich() {

        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("Select * from ArirangSongList where YEUTHICH=1",null);
        dsYeuThich.clear();
        while (cursor.moveToNext())
        {
            String MaBH=cursor.getString(0);
            String TenBH=cursor.getString(1);
            String CaSi=cursor.getString(3);
            int YeuThich=cursor.getInt(5);
            String KeyYoutube=cursor.getString(6);

            Music music=new Music();
            music.setMaBH(MaBH);
            music.setTenBH(TenBH);
            music.setCaSi(CaSi);
            music.setYeuThich(YeuThich==0);
            music.setKeyYoutube(KeyYoutube);
            dsYeuThich.add(music);
        }
        cursor.close();
        adapterYeuThich.notifyDataSetChanged();
    }

    private void xuLyHienThiBaiHat() {
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("SELECT * FROM ArirangSongList",null);
        dsBaiHat.clear();
        while (cursor.moveToNext())
        {
            String MaBH=cursor.getString(0);
            String TenBH=cursor.getString(1);
            String CaSi=cursor.getString(3);
            int YeuThich=cursor.getInt(5);
            String KeyYoutube=cursor.getString(6);

            Music music=new Music();
            music.setMaBH(MaBH);
            music.setTenBH(TenBH);
            music.setCaSi(CaSi);
            music.setYeuThich(YeuThich==1);
            music.setKeyYoutube(KeyYoutube);
            dsBaiHat.add(music);
        }
        cursor.close();
        adapterBaiHat.notifyDataSetChanged();
    }

    //endregion;

    private void addControls() {


        //region Add TabHost
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabBaiHat=tabHost.newTabSpec("t1");
        tabBaiHat.setContent(R.id.tabBaiHat);
        tabBaiHat.setIndicator("",getResources().getDrawable(R.drawable.ok));
        tabHost.addTab(tabBaiHat);

        TabHost.TabSpec tabYeuThich=tabHost.newTabSpec("t2");
        tabYeuThich.setContent(R.id.tabYeuThich);
        tabYeuThich.setIndicator("",getResources().getDrawable(R.drawable.tym));
        tabHost.addTab(tabYeuThich);

        TabHost.TabSpec tabSearch=tabHost.newTabSpec("t3");
        tabSearch.setContent(R.id.tabSearch);
        tabSearch.setIndicator("",getResources().getDrawable(R.drawable.timkiem));
        tabHost.addTab(tabSearch);

        //endregion;

        //region Controls
        btnDislike=findViewById(R.id.btnDisLike);
        btnLike=findViewById(R.id.btnLike);
        lvBaiHat=findViewById(R.id.lvBaiHat);
        lvYeuThich=findViewById(R.id.lvYeuThich);
        tvTenBH=findViewById(R.id.tvTenBaiHat);
        txtTimBH=findViewById(R.id.txtTimBaiHat);
        txtTimBH.setSelected(false);
        txtTimYT=findViewById(R.id.txtTimYeuThich);
        txtTimYT.setSelected(false);
        btnTimBH=findViewById(R.id.btnTimBH);
        btnTimYT=findViewById(R.id.btnTimYT);

        txtSearch=findViewById(R.id.txtSearch);
        txtSearch.setSelected(false);
        btnTimBHOnline=findViewById(R.id.btnTimBHOnline);
        recycleViewYoutubeSearch=findViewById(R.id.recycleViewYoutubeSearch);
        //endregion;

        //region Set Data to Adapter

        dsBaiHat=new ArrayList<>();
        adapterBaiHat=new AdapterMusic(
                MainActivity.this,
                R.layout.item,
                dsBaiHat
        );
        lvBaiHat.setAdapter(adapterBaiHat);

        dsYeuThich=new ArrayList<>();
        adapterYeuThich=new AdapterMusic(
                MainActivity.this,
                R.layout.item,
                dsYeuThich
        );
        lvYeuThich.setAdapter(adapterYeuThich);

        //endregion;

        xuLyHienThiBaiHat();

        //Fixing the size of recycler view which means that the size of the view
        //should not change if adapter or children size changes
        recycleViewYoutubeSearch.setHasFixedSize(true);
        //give RecyclerView a layout manager to set its orientation to vertical
        //by default it is vertical
        recycleViewYoutubeSearch.setLayoutManager(new LinearLayoutManager(this));

        handler = new Handler();

        searchOnYoutube("Top karaoke Viet Nam");
    }
    // show Intro
    private void showIntro(){
        startActivity(new Intent(MainActivity.this, IntroActivity.class));
        Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                .show();
        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }

    //custom search method which takes argument as the keyword for which videos is to be searched
    private void searchOnYoutube(final String keywords){

        //A thread that will execute the searching and inflating the RecyclerView as and when
        //results are found
        new Thread(){

            //implementing run method
            public void run(){

                //create our YoutubeConnector class's object with Activity context as argument
                YoutubeConnector yc = new YoutubeConnector(MainActivity.this);

                //calling the YoutubeConnector's search method by entered keyword
                //and saving the results in list of type VideoItem class
                searchResults = yc.search(keywords);

                //handler's method used for doing changes in the UI
                handler.post(new Runnable(){

                    //implementing run method of Runnable
                    public void run(){

                        //call method to create Adapter for RecyclerView and filling the list
                        //with thumbnail, title, id and description
                        fillYoutubeVideos();

                        //after the above has been done hiding the ProgressDialog
                        //mProgressDialog.dismiss();
                    }
                });
            }
            //starting the thread
        }.start();
    }

    //method for creating adapter and setting it to recycler view
    private void fillYoutubeVideos(){

        //object of YoutubeAdapter which will fill the RecyclerView
        youtubeAdapter = new YoutubeAdapter(getApplicationContext(),searchResults);

        //setAdapter to RecyclerView
        recycleViewYoutubeSearch.setAdapter(youtubeAdapter);

        //notify the Adapter that the data has been downloaded so that list can be updapted
        youtubeAdapter.notifyDataSetChanged();
    }

}
