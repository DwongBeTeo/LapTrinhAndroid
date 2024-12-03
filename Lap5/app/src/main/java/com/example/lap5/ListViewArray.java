package com.example.lap5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewArray extends AppCompatActivity {

    //khai bao'
    ListView lstMonHoc;
    String[] arrMonHoc;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_array);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addView();
        addEvent();
    }
    private void addView(){
        lstMonHoc=findViewById(R.id.lstMonHoc);
        arrMonHoc=new String[]{"Toan","Van","Anh"};
        adapter = new ArrayAdapter<>(ListViewArray.this, android.R.layout.simple_list_item_1,arrMonHoc);
        lstMonHoc.setAdapter(adapter);
    }
    private void addEvent() {
        lstMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewArray.this, "arrMonHoc[i]", Toast.LENGTH_SHORT).show();
            }
        });
    }
}