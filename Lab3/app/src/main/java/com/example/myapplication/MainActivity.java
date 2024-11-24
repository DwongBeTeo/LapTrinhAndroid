package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        findViewById(R.id.btnBai1).setOnClickListener(v -> openExerciseActivity(Bai1.class));
        findViewById(R.id.btnBai2).setOnClickListener(v -> openExerciseActivity(Bai2.class));
//        findViewById(R.id.btnBai3).setOnClickListener(v -> openExerciseActivity(Bai3.class));
    }
    private void openExerciseActivity(Class<?> activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }
}