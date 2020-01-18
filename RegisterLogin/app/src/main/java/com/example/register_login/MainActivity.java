package com.example.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername,mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;

    DataBaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseHelper(this);

        mTextUsername = findViewById(R.id.mTextUsername);
        mTextPassword = findViewById(R.id.mTextPassword);
        mButtonLogin = findViewById(R.id.mButtonLogin);
        mTextViewRegister = findViewById(R.id.mTextViewRegister);

         mTextViewRegister.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent registerIntent = new Intent(MainActivity.this,Register.class);
                 startActivity(registerIntent);
             }
         });


         mButtonLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             String user = mTextUsername.getText().toString().trim();
             String pwd = mTextPassword.getText().toString().trim();
             Boolean res = db.checkUser(user,pwd);

             if(res==true)
             {
                 Toast.makeText(MainActivity.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this,Welcome.class);
             }

             else
             {
                 Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
             }


             }
         });


    }
}
