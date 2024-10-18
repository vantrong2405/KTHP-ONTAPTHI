package com.example.intentan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SendSMSActivity extends AppCompatActivity {
  EditText editSMS ;
  ImageButton btnSMSData;
  Button btnBack2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);
//        ÁNh xạ id
        editSMS = findViewById(R.id.edtSMS);
        btnSMSData = findViewById(R.id.btnDataSMS);
        btnBack2 = findViewById(R.id.btnBack2);

//        Xử lý click
        btnSMSData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Khai báo intent ẩn để gọi ưng sdunjg sms
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+editSMS.getText().toString()));
                startActivity(smsIntent);
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}