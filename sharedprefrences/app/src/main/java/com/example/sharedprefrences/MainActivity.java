package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String myprefrence ="myprefs";
    public static final String Name ="nameKey";
    public static final String Email ="mailKey";

    EditText name;
    EditText email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.etname);
        email = findViewById(R.id.etmail);

        sharedPreferences = getSharedPreferences(myprefrence, Context.MODE_PRIVATE);



    }




    public void Save(View view) {


        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.commit();
    }


    public void Clear(View view) {


        name.setText("");
        email.setText("");

    }




    public void Retrive(View view){
        sharedPreferences = getSharedPreferences(myprefrence,Context.MODE_PRIVATE);

        if(sharedPreferences.contains(Name)) {

            String test = sharedPreferences.getString(Name, "");
            name.setText(test);
        }

        if (sharedPreferences.contains(Email)) {

            String test2 = sharedPreferences.getString(Email,"");
            email.setText(test2);
        }




    }







}
