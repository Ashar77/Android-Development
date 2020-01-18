package com.example.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DataBaseHelper db;
    EditText mTextUsername,mTextPassword,mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBaseHelper(this);

        mTextUsername = findViewById(R.id.mTextUsername);
        mTextPassword = findViewById(R.id.mTextPassword);
        mButtonRegister = findViewById(R.id.mButtonRegister);
        mTextViewLogin = findViewById(R.id.mTextViewLogin);
        mTextCnfPassword = findViewById(R.id.mTextCnfPassword);

        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LoginIntent = new Intent(Register.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });


        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user =mTextUsername.getText().toString().trim();
                String pwd =mTextPassword.getText().toString().trim();
                String cnf_pwd =mTextCnfPassword.getText().toString().trim();

                if (pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);

                    if (val<0){

                    Toast.makeText(Register.this,"You have Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(Register.this,MainActivity.class);
                    startActivity(moveToLogin); }

                    else{
                        Toast.makeText(Register.this,"Registration Error",Toast.LENGTH_SHORT).show();

                    }


                }

                else{
                    Toast.makeText(Register.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
