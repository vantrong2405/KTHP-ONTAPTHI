package com.example.doanvovantrong_bai1;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText Vn, NgoaiTe;
    RadioGroup check;
    Button btnVNTo, btnToVN, btnClear;
    RadioGroup radioCheck;
    RadioButton usd, eur, jpy;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vn = findViewById(R.id.edtTextVND);
        NgoaiTe = findViewById(R.id.edtNgoaiTe);
        btnVNTo = findViewById(R.id.btnVnTo);
        btnToVN = findViewById(R.id.btnToVN);
        btnClear = findViewById(R.id.btn_clear);
        radioCheck = findViewById(R.id.check);
        usd = findViewById(R.id.usd);
        eur = findViewById(R.id.eur);
        jpy = findViewById(R.id.jpy);

        btnVNTo.setOnClickListener(
                view -> {
                    int VND = Integer.parseInt(Vn.getText().toString());
                    int result = 0;
                    int id = radioCheck.getCheckedRadioButtonId();
                    RadioButton rad = findViewById(id);
                    String check = rad.getText() + "";
                    if(VND < 0) {
                        Toast.makeText(MainActivity.this, "So tien nhap vao phai lon hon 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(check.equals("USD")) {
                        result = VND / 22280;
                    }
                    if(check.equals("EUR")) {
                        result = VND / 24280;
                    }
                    if(check.equals("JPY")) {
                        result = VND / 204;
                    }
                    NgoaiTe.setText(result + "");
                }
        );

        btnToVN.setOnClickListener(
                view -> {
                    int NT = Integer.parseInt(NgoaiTe.getText().toString());
                    int result = 0;
                    int id = radioCheck.getCheckedRadioButtonId();
                    RadioButton rad = findViewById(id);
                    String check = rad.getText() + "";
                    if(NT < 0) {
                        Toast.makeText(MainActivity.this, "So tien nhap vao phai lon hon 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(check.equals("USD")) {
                        result = NT * 22280;
                    }
                    if(check.equals("EUR")) {
                        result = NT * 24280;
                    }
                    if(check.equals("JPY")) {
                        result = NT * 204;
                    }
                    Vn.setText(result + "");
                }
        );

        btnClear.setOnClickListener(
                view -> {
                    Vn.setText("");
                    NgoaiTe.setText("");
                }
        );

    }
    public void onBackPressed() {
        AlertDialog.Builder b =new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setPositiveButton("Yes", (dialog, which) -> finish());
        b.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        b.create().show();
    }
}