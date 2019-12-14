package com.example.intents1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

                else {

                    String name = etname.getText().toString().trim();
                }


            //    Intent intent = new Intent(MainActivity.this,);

            }
        });



        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




           }
}
