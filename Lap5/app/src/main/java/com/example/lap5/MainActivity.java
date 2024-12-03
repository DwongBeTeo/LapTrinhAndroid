package com.example.lap5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
     Button moListViewArr, moArrayList, moListViewObject, moBai5_1;
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
    }
    public void moListViewArr(View view){
        Intent intent = new Intent (MainActivity.this, ListViewArray.class);
        startActivity(intent);
    }
    public void moArrayList(View view){
        Intent intent = new Intent (MainActivity.this, ListViewList.class);
        startActivity(intent);
    }


    public void moListViewObject(View view) {
        Intent intent = new Intent (MainActivity.this, ListViewObject.class);
        startActivity(intent);
    }

    public void moBai5_1(View view) {
        Intent intent = new Intent (MainActivity.this, Lap5_1.class);
        startActivity(intent);
    }
}