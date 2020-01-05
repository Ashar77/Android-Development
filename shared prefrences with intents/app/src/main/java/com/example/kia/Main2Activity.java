package com.example.kia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kia.R;

public class Main2Activity extends AppCompatActivity {





    SharedPreferences sharedPreferences;
    public static final String myprefrence ="myprefs";
    public static final String Name ="nameKey";


    TextView tvwelcome;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences(myprefrence, Context.MODE_PRIVATE);

        tvwelcome = findViewById(R.id.tvwelcome);


        String the_name = getIntent().getStringExtra("the_name");

        tvwelcome.setText(the_name+", Welcome to our App");





    }
}
