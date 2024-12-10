package com.example.listviewspiner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.Model.DanhMuc;
import com.example.Model.SanPham;

public class MainActivity extends AppCompatActivity {
    EditText edtmasp,edttensp,edtgiasp;
    Spinner spndanhsach;
    ListView lstsanpham;
    Button btnthemsp;
    ArrayAdapter<DanhMuc> danhMucAdapter;
    ArrayAdapter<SanPham> sanphamAdapter;
    DanhMuc selectedDanhMuc=null;
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
        addView();
        addEvent();
    }

    private void addEvent() {
        btnthemsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyNhapSanPham();
            }
        });
        spndanhsach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDanhMuc=danhMucAdapter.getItem(position);
                sanphamAdapter.clear();
                sanphamAdapter.addAll(selectedDanhMuc.getSanphams());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void xulyNhapSanPham() {
        SanPham sanPham=new SanPham(edtmasp.getText().toString(),edttensp.getText().toString(),Integer.parseInt(edtgiasp.getText().toString()));
        selectedDanhMuc.getSanphams().add(sanPham);
        sanphamAdapter.add(sanPham);
    }

    private void addView() {
        spndanhsach=findViewById(R.id.spnSP);
        danhMucAdapter = new ArrayAdapter<DanhMuc>(MainActivity.this, android.R.layout.simple_spinner_item);
        spndanhsach.setAdapter(danhMucAdapter);
        lstsanpham=findViewById(R.id.DSSP);
        sanphamAdapter = new ArrayAdapter<SanPham>(MainActivity.this, android.R.layout.simple_list_item_1);
        lstsanpham.setAdapter(sanphamAdapter);
        edtmasp = findViewById(R.id.edtMaSP);
        edtgiasp = findViewById(R.id.edtGiaSP);
        edttensp = findViewById(R.id.edtTenSP);
        btnthemsp = findViewById(R.id.btnthemsp);
        danhMucAdapter.add(new DanhMuc("1","bia"));
        danhMucAdapter.add(new DanhMuc("2","thuốc"));
        danhMucAdapter.add(new DanhMuc("3","rượu"));
        danhMucAdapter.add(new DanhMuc("4","nước ngọt"));

    }
}