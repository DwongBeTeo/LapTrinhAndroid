package com.example.chuandoancannang;

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

public class MainActivity extends AppCompatActivity {
    //Khai báo các giao diện
    EditText edtTen, edtHeight, edtWeight;
    Button btnBMI;
    TextView tvBMI,tvResult;
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
        //ánh xạ id
        edtTen = findViewById(R.id.edtTen);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);
        btnBMI=findViewById(R.id.btnBMI);
        tvBMI=findViewById(R.id.tvBMI);
        tvResult=findViewById(R.id.tvResult);
        //xử lý nút tính BMI
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText va` Chuyển đổi dữ liệu
                double ChieuCao = Double.parseDouble(edtHeight.getText().toString());
                double CanNang = Double.parseDouble(edtWeight.getText().toString());
                double BMI= CanNang/(ChieuCao*ChieuCao);
                tvBMI.setText("BMI ="+BMI);
                //Chẩn đoán tình trạng cơ thể
                String chanDoan;
                if (BMI<18){
                    chanDoan="Bạn gầy";
                } else if (BMI>=18 && BMI<=24.9) {
                    chanDoan="người bình thường";
                } else if (BMI>=25 && BMI<=29.9) {
                    chanDoan="người béo phì độ I";
                } else if(BMI>=30 && BMI<=34.9){
                    chanDoan="người béo phì độ II";
                } else {
                    chanDoan="người béo phì độ III";
                }
                // Hiển thị chẩn đoán
                tvResult.setText("Chẩn đoán: "+chanDoan);
            }
        });
    }
}