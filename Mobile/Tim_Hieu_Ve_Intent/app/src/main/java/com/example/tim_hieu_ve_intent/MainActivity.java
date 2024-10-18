package com.example.tim_hieu_ve_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button btnOpen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpen = findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Khai báo intent
                Intent myIntent = new Intent(MainActivity.this,Child_activity.class);
                // Nó có 2 tham số là tham số nguồn và tham số đích
                startActivity(myIntent);//DÙng để khởi chạy myIntent
            }
        });
    }
}