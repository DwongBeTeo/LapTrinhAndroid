package com.example.congtrunhanchia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //khai báo giao diện
    EditText edtA, edtB;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // ánh xạ id
        edtA=findViewById(R.id.edtA);
        edtB=findViewById(R.id.edtB);
        btnCong=findViewById(R.id.btnCong);
        btnTru=findViewById(R.id.btnTru);
        btnNhan=findViewById(R.id.btnNhan);
        btnChia=findViewById(R.id.btnChia);
        tvResult=findViewById(R.id.tvResult);
        //xử lý nút Cong
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText va` Chuyển đổi dữ liệu
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double c = a+b;
                tvResult.setText("Tong A+B la: "+c);
            }
        });
        // xử lý nút Tru
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText va` Chuyển đổi dữ liệu
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double c =a-b;
                tvResult.setText("Hieu a-b la: "+c);
            }
        });
        // xử lý nút Nhan
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText va` Chuyển đổi dữ liệu
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double c = a*b;
                tvResult.setText("Tích A*B là: "+c);
            }
        });
        // xử lý nút chia
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText va` Chuyển đổi dữ liệu
                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                if (b==0){
                    tvResult.setText("Không thể chia cho 0!");
                } else {
                    double c =a/b;
                    tvResult.setText("Hiệu A/B là: "+c);
                }
            }
        });
    }
}