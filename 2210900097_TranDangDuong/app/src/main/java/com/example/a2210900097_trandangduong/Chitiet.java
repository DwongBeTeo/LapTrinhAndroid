package com.example.a2210900097_trandangduong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chitiet extends AppCompatActivity {
    Intent intent97;
    EditText edtMaSP97,edtTenSP97,edtSL97,edtDonGia97;
    Button btnquaylai97;
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

    private void addevent() {
    }

    private void addview() {
        intent97=getIntent();
        edtMaSP97=findViewById(R.id.edtMaSP97);
        edtTenSP97=findViewById(R.id.edtTenSP97);
        edtSL97=findViewById(R.id.edtSL97);
        edtDonGia97=findViewById(R.id.edtDonGia97);
        btnquaylai97=findViewById(R.id.btnquaylai97);
        SanPham sp97=(SanPham) intent97.getSerializableExtra("SanPham");
        edtMaSP97.setText(sp97.getMaSanPham()+"");
        edtMaSP97.setEnabled(false);
        edtTenSP97.setText(sp97.getTenSanPham());
        edtSL97.setText(sp97.getSoLuong());
        edtDonGia97.setText(sp97.getDonGia()+"");
    }
}

