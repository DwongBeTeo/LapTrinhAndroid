package com.example.lap5;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewList extends AppCompatActivity {
    ListView lstMonHoc;
    ArrayList<String> arrMonHoc;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_list);
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
        arrMonHoc = new ArrayList<>();
        adapter = new ArrayAdapter(ListViewList.this, android.R.layout.simple_list_item_1,arrMonHoc);
        lstMonHoc.setAdapter(adapter);
        arrMonHoc.add("Toan");
        arrMonHoc.add("anh");
        arrMonHoc.add("Van");
    }
    

}