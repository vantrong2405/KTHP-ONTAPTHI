package com.example.chuyendoilich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   TextView edtDuong , edtKQ;
   Button  btnChuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ÁNh xạ id
        edtDuong = findViewById(R.id.edtDuong);
        edtKQ = findViewById(R.id.edtKQ);
        btnChuyen = findViewById(R.id.btnChuyen);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam_am , chi="" , can = "";
                int namDuong = Integer.parseInt(edtDuong.getText().toString());
                switch (namDuong % 10 ){
                    case 0 :{
                          can = "Canh";
                        break;
                    }
                    case 1 :{
                        can = "Tân";
                        break;
                    }case 2 :{
                        can = "Nhâm";
                        break;
                    }case 3 :{
                        can = "Qúy";
                        break;
                    }case 4 :{
                        can = "Giáp";
                        break;
                    }case 5 :{
                        can = "Ất";
                        break;
                    }case 6 :{
                        can = "Bính";
                        break;
                    }case 7 :{
                        can = "Đinh";
                        break;
                    }case 8 :{
                        can = "Mâu";
                        break;
                    }case 9 :{
                        can = "Kỷ";
                        break;
                    }
                }

                switch (namDuong % 12 ){
                    case 0 :{
                        chi = "Thân";
                        break;
                    }
                    case 1 :{
                        chi = "Dậu";
                        break;
                    }case 2 :{
                        chi = "Tuất";
                        break;
                    }case 3 :{
                        chi = "Hợi";
                        break;
                    }case 4 :{
                        chi = "Tý";
                        break;
                    }case 5 :{
                        chi = "Sửu";
                        break;
                    }case 6 :{
                        chi = "Dần";
                        break;
                    }case 7 :{
                        chi = "Mẹo";
                        break;
                    }case 8 :{
                        chi = "Thìn";
                        break;
                    }case 9 :{
                        chi = "Tỵ";
                        break;
                    }
                    case 10 :{
                        chi = "Ngọ";
                        break;
                    }
                    case 11 :{
                        chi = "Mùi";
                        break;
                    }
                }

                edtKQ.setText(can+ "" + chi);
            }
        });
    }
}