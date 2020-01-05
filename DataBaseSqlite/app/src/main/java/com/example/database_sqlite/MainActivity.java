package com.example.database_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;

    EditText etName,etSurname,etMarks;
    Button btnAddData,btnViewAll;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataBaseHelper(this);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etMarks = findViewById(R.id.etMarks);

        btnAddData = findViewById(R.id.btnAddData);
        btnViewAll = findViewById(R.id.btnViewAll);


        ViewAll();




        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(etName.getText().toString(),etSurname.getText().toString(),etMarks.getText().toString());

                if(isInserted==true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_SHORT).show();

                }
            }
        });









    }


    public void ViewAll(){


        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res =   myDb.getAllData();

                if(res.getCount()==0){
                    //show message
                    showMessage("Error","No Data Found!");
                    return;
                }


                StringBuffer buffer = new StringBuffer();

                //fetching data

                while (res.moveToNext()){
                    buffer.append("Id :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Surname :"+res.getString(2)+"\n");
                    buffer.append("Marks :"+res.getString(3)+"\n\n");

                }

                // show all data
                showMessage("Data",buffer.toString());

            }
        });
    }






    public  void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}





