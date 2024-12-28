package com.example.lap6_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.Sanpham2chieu;

public class chuyendoi2man extends AppCompatActivity {
    ListView lvsanpham;
    ArrayAdapter<Sanpham2chieu> adtsanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuyendoi2man);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        addview();
        addevent();
    }
    private void addview() {
        lvsanpham = findViewById(R.id.lstdanhsach);
        adtsanpham = new ArrayAdapter<Sanpham2chieu>(chuyendoi2man.this, android.R.layout.simple_list_item_1);
        lvsanpham.setAdapter(adtsanpham);
        adtsanpham.add(new Sanpham2chieu("001",20000,"sữa tươi"));
        adtsanpham.add(new Sanpham2chieu("002",34000,"kem dâu"));
        adtsanpham.add(new Sanpham2chieu("003",50000,"kẹo ong"));
    }

    private void addevent() {
        lvsanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sanpham2chieu sanpham2chieu = adtsanpham.getItem(position);
                Intent intent = new Intent(chuyendoi2man.this,MainActivity.class);
                intent.putExtra("Sanpham",sanpham2chieu);
                startActivityForResult(intent,113);
            }
        });

    }
}