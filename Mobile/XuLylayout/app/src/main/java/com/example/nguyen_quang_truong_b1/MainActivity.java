package com.example.nguyen_quang_truong_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.samsung,R.drawable.ip,R.drawable.htc,R.drawable.wp,R.drawable.lg,R.drawable.sky};
    String name[] = {"Điện thoại SamSung","Điện thoại Iphone","Điện thoại HTC","Điện thoại windowPhone","Điện thoại LG","Diện thoại Sky"};
    ArrayList<Phone> mylist;
    MyArrayAdapter myadapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        for (int i =0;i<name.length;i++){
            mylist.add(new Phone(image[i],name[i]));

        }
        myadapter = new MyArrayAdapter(MainActivity.this,R.layout.layout_item,mylist);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this,Sub_Activity.class); 
                myintent.putExtra("name",name[position]);
                startActivity(myintent);
            }
        });
    }
}