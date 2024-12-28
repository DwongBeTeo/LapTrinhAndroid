package com.example.lap08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chitiet extends AppCompatActivity {
    Intent intent;//intent nhận dữ liệu
    EditText edtMa,edtTen,edtDienThoai;
    Button btnThemSua, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chitiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addview();
        addevent();
    }
    private void addview() {
        intent=getIntent();
        edtMa=findViewById(R.id.edtMa);
        edtTen=findViewById(R.id.edtTen);
        edtDienThoai=findViewById(R.id.edtDT);
        btnThoat=findViewById(R.id.btnThoat);
        Contact ct=(Contact) intent.getSerializableExtra("CONTACT");
        edtMa.setText(ct.getMa()+"");
        edtMa.setEnabled(false);
        edtTen.setText(ct.getTen());
        edtDienThoai.setText(ct.getDienthoai());
    }
    private void addevent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Chitiet.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }

}