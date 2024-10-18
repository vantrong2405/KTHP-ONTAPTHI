package com.example.thongtincanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtCMND , edtHoTen , edtBoSung;
    RadioGroup rdBangCap;
    Button btnGuiTT ;
    CheckBox cbDocBao , cbDocSach , cbCoding ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ÁNh xạ id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBoSung = findViewById(R.id.edtNhapThongTin);
        btnGuiTT = findViewById(R.id.btnGuiThongTin);
        rdBangCap = findViewById(R.id.rdBangCap);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbCoding = findViewById(R.id.cbCoding);

        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                if(hoTen.length() < 3){
                    Toast.makeText(MainActivity.this, "Họ tên >= 3 ký tự", Toast.LENGTH_SHORT).show();
//                    Đưa con trỏ trở về và bôi đen all dòng đã nhập
                    edtHoTen.requestFocus();// đưa con trỏ về đầu chỗ nhập
                    edtHoTen.selectAll();// bôi đen a;; edtHoTen
                    return;//CHo nhập lại
                }

//                Lấy thông tin CMND
                String cmnd = edtCMND.getText().toString();
                if(cmnd.length()  != 9 ){
                    Toast.makeText(MainActivity.this, "CMND Phải đúng 9 số", Toast.LENGTH_SHORT).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                    return ; //cho nhập lại ko đi xuống
                }

//                Lấy thông tin radio group
                int idselect = rdBangCap.getCheckedRadioButtonId();//lấy id của từng ô
                RadioButton radselect = findViewById(idselect);// tạo ra biến radio để tìm đúng id của từng ô đó
                String bangcap = radselect.getText().toString();// Đầu tiên tìm idgroup xong dùng radselect để ánh xạ id đó ,
                //rùi lấy data id đó
//                Lấy thông tin sở thích
                String soThich = "";
                if(cbDocSach.isChecked()){
                    soThich += cbDocSach.getText().toString()+"-";
                }else if (cbDocBao.isChecked()){
                    soThich += cbDocBao.getText().toString()+"-";
                }else{
                    soThich += cbCoding.getText().toString();
                }
                String boSung = edtBoSung.getText().toString();
                String tongHop = hoTen + "\n" + cmnd + "\n" + bangcap + "\n" + soThich + "\n";
                tongHop += "------Thông tin bổ sung------\n";
                tongHop += boSung+"\n";
                tongHop+="-------------------------";
                //Tạo hộp thoại dialog
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);//Tạo dialog
                myDialog.setTitle("Thông tin cá nhân");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.create().show();//
            }
        });
    }
}