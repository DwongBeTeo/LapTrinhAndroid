package com.example.lap5;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.MonHoc;

public class ListViewObject extends AppCompatActivity {
    ListView lstMonHoc;
    ArrayAdapter<MonHoc>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_object);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addView();
        addEvent();
    }

    private void addEvent() {
    }

    private void addView() {
        lstMonHoc=findViewById(R.id.lstMonHoc);
        adapter=new ArrayAdapter<>(ListViewObject.this, android.R.layout.simple_list_item_1);
        lstMonHoc.setAdapter(adapter);
        adapter.add(new MonHoc(1,45,"Duong"));
        adapter.add(new MonHoc(1,45,"haha"));
        adapter.add(new MonHoc(1,45,"Hehe"));
        adapter.add(new MonHoc(1,45,"hoho"));
    }

}