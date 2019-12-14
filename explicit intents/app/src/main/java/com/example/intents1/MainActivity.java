package com.example.intents1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    Button btnAct2,btnAct3;
    TextView tvresults;

    final int ACTIVITY3 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etname);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvresults = findViewById(R.id.tvresults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(etname.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please fill all feilds",Toast.LENGTH_SHORT).show();
                }


                else
                    {
                    String name = etname.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this,com.example.intents1.Main2Activity.class);

                    intent.putExtra("name", name);
                    startActivity(intent); }






            }
        });



        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,com.example.intents1.Main3Activity.class);

                startActivityForResult(intent,ACTIVITY3);

            }
        });



           }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==ACTIVITY3){

            if (resultCode==RESULT_OK){
                tvresults.setText(data.getStringExtra("surname"));

            }

            if (resultCode==RESULT_CANCELED){
            tvresults.setText("you have canceled the operation!");

        }


        }


    }





}
