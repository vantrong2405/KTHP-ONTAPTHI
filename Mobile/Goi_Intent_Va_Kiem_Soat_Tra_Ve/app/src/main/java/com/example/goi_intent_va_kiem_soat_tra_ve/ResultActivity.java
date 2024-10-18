package com.example.goi_intent_va_kiem_soat_tra_ve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
  EditText edtNhan ;
  Button btnGoc , btnGuiBinhPhuong;
  Intent myIntent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        edtNhan = findViewById(R.id.edtDuLieuNhan);
        btnGoc = findViewById(R.id.btnGuiGoc);
        btnGuiBinhPhuong = findViewById(R.id.btnGuiBinhPhuong);
         myIntent = getIntent();//Nhận intent bên kia
//        Lấy dữ liệu trong Intent ra
        int a = myIntent.getIntExtra("soa",0);//đúng key bên kia , bên kia đặt là soa , nếu lấy dữ liệu không thành công
        //thì dữ liệu nhận được sẽ là 0
        edtNhan.setText(a + "");

        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent.putExtra("kq",a);
                setResult(33 , myIntent);
                finish();
            }
        });

        btnGuiBinhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent.putExtra("kq", (a*a));
                setResult(38,myIntent);
                finish();
            }
        });
    }
}