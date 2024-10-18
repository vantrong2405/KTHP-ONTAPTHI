package com.example.intentan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCall , btnSendSMS ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = findViewById(R.id.btnCall);
        btnSendSMS = findViewById(R.id.btnSend);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khao báp intent công khai
                Intent myIntent = new Intent(MainActivity.this , CallPhoneActivity.class);
                startActivity(myIntent);
            }
        });
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khao báp intent công khai
                Intent myIntent2 = new Intent(MainActivity.this , SendSMSActivity.class);
                startActivity(myIntent2);
            }
        });
    }
}