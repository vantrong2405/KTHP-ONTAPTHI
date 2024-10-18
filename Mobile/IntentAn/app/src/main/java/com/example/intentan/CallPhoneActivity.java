package com.example.intentan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CallPhoneActivity extends AppCompatActivity {
   EditText edtDataCall;
   Button  btnBack ;
   ImageButton btnDataCall ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        edtDataCall = findViewById(R.id.edtDataCall);
        btnDataCall = findViewById(R.id.btnDataCall);
        btnBack = findViewById(R.id.btnBack);


        btnDataCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_CALL , Uri.parse("tel:"+edtDataCall.getText().toString()));
//                Yêu cầu với sự đồng ý của ng dùng
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this, new
                            String[]{android.Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callintent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}