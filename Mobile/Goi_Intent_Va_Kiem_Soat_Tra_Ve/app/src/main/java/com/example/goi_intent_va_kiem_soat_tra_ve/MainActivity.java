package com.example.goi_intent_va_kiem_soat_tra_ve;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtData , edtKQ ;
    Button btnYC ;
    Intent myIntentB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.edtData);
        edtKQ = findViewById(R.id.edtKQ);
        btnYC = findViewById(R.id.btnYeuCauKQ);

        btnYC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtData.getText().toString());
//                Đưa dữ liệu vào myIntent
                myIntent.putExtra("soa",a);
                startActivityForResult(myIntent , 99); // Tham số để khởi động my Intent
                // tham số 1 : tên Intent , tham số 2 : số đ ký hiệu Intent vì có nhiều Intent
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị gốc là : "+14 + "");
        }
        if(resultCode == 99 && resultCode == 38){
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị BP là : "+13+ "");
        }

    }
}