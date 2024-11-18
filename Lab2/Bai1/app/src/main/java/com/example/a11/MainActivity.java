package com.example.a11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến giao diện
    EditText edtC,edtF;
    Button btnCF,btnFC,btnclear;
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
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnclear = findViewById(R.id.btnclear);
        //xử lý tương tác với người dùng
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("0.00");
                int C = Integer.parseInt(edtC.getText().toString());
                double F = C*1.8+32;
                edtF.setText(dcf.format(F)+"");
            }
        });
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("0.00");
                int F = Integer.parseInt(edtF.getText().toString());
                double C = (F-32)/1.8;
                edtC.setText(dcf.format(C)+"");
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}