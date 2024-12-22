package com.example.nndb.finalkaraoke.Model.Adapter;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nndb.finalkaraoke.Model.DTO.Music;
import com.example.nndb.finalkaraoke.R;
import com.example.nndb.finalkaraoke.View.MainActivity;
import com.example.nndb.finalkaraoke.View.MainYoutube;

import java.util.List;

public class AdapterMusic extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;
    public AdapterMusic(@NonNull Activity context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView tvMa=row.findViewById(R.id.tvMaSo);
        TextView tvTen=row.findViewById(R.id.tvTenBaiHat);
        TextView tvCaSi=row.findViewById(R.id.tvCaSi);
        ImageButton btnLike=row.findViewById(R.id.btnLike);
        ImageButton btnDisLike=row.findViewById(R.id.btnDisLike);
        final Music muSicTruyen=this.objects.get(position);
        tvTen.setText(muSicTruyen.getTenBH());
        tvMa.setText(muSicTruyen.getMaBH());
        tvCaSi.setText(muSicTruyen.getCaSi());

        if (muSicTruyen.isYeuThich())
        {
            btnLike.setVisibility(View.INVISIBLE);
            btnDisLike.setVisibility(View.VISIBLE);
        }
        else
        {
            btnLike.setVisibility(View.VISIBLE);
        }

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(muSicTruyen);
            }
        });

        btnDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyKhongThich(muSicTruyen);
            }
        });

        return row;

    }

    private void xuLyKhongThich(Music muSicTruyen) {
        ContentValues row=new ContentValues();
        row.put("YEUTHICH",0);
        MainActivity.database.update("ArirangSongList",row,"MABH=?",new String[]{muSicTruyen.getMaBH()});
    }

    private void xuLyThich(Music muSicTruyen) {
        ContentValues row=new ContentValues();
        row.put("YEUTHICH",1);
        MainActivity.database.update("ArirangSongList",row,"MABH=?",new String[]{muSicTruyen.getMaBH()});

    }
}
