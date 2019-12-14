package com.example.intents1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvwelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvwelcome = findViewById(R.id.tvwelcome);

        String name = getIntent().getStringExtra("name");

        tvwelcome.setText(name + ", welcome to Activity 2!");


    }
}
