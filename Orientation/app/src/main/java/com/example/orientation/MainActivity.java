package com.example.orientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMe trics(). heightPixels)          {
            Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).show();          }
        else          {
            Toast.makeText(this,"Screen switched to Portrait mode",Toast.LENGTH_SHORT).show();          }
    }
}
