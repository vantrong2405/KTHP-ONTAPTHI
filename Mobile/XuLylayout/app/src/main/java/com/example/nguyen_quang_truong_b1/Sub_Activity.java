package com.example.nguyen_quang_truong_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sub_Activity extends AppCompatActivity {
    TextView txt_Subphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txt_Subphone = findViewById(R.id.txt_Subphone);
        Intent myintent = getIntent();
        String namephone = myintent.getStringExtra("name");
        txt_Subphone.setText(namephone);
    }
}