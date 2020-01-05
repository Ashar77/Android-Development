package com.example.kia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kia.Main2Activity;
import com.example.kia.R;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    public static final String myprefrence ="myprefs";
    public static final String Name ="nameKey";


    EditText etName;
    Button btnSave;
    Button btnContinue;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etname);
        btnSave = findViewById(R.id.btnsave);
        btnContinue = findViewById(R.id.btncontinue);

        sharedPreferences = getSharedPreferences(myprefrence, Context.MODE_PRIVATE);



    }


    public void Save(View view) {

        String n = etName.getText().toString().trim();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Name , n);
        editor.commit();
    }



    public void Continue(View view){

        sharedPreferences = getSharedPreferences(myprefrence,Context.MODE_PRIVATE);



        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        String na = sharedPreferences.getString(Name,"");



        intent.putExtra("name",na);
        startActivity(intent);



    }














}
