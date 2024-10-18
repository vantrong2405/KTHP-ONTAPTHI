package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   EditText edtFa , edtCe ;
   Button btn1 , btn2 , btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtFa = findViewById(R.id.edtFa);
        edtCe = findViewById(R.id.edtCe);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtFa.setText("");
                edtCe.setText("");
            }
        });
//        convert to sel
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int C = Integer.parseInt(edtCe.getText().toString());
                Double F = C * 1.8 + 32 ;
                edtFa.setText(F+"");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int F = Integer.parseInt(edtCe.getText().toString());
                Double C = (F-32) / 1.8 ;
                edtFa.setText(C+"");
            }
        });
    }
}