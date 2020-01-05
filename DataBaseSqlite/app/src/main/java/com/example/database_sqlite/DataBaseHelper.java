package com.example.database_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "students_table";
    private static final String COL_1 = "id";
    private static final String COL_2 = "name";
    private static final String COL_3 = "surname";
    private static final String COL_4 = "marks";




    public DataBaseHelper(Context context) {                        // constructor of this helper class
        super(context, DATABASE_NAME, null, 1);         //creating database in the constructor of this class

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT,"+ COL_4 + " INTEGER"+ ")";
        db.execSQL(CREATE_TABLE);                             // execute the given arguments

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       onCreate(db);

    }


    public boolean insertData(String name,String surname,String marks){

        SQLiteDatabase db = this.getWritableDatabase();  // instance of SQLiteDatabase class

        ContentValues contentValues = new ContentValues(); // instance of ContentValues

        contentValues.put(COL_2,name);          // column , value to be put in the column
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);

        long result = db.insert(TABLE_NAME,null,contentValues); // returns -1 in case of error

        if(result==-1){
            return false;
        }
        else{
            return true;
        }



    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();

        String viewAllQuery = "select * from";

        Cursor res = db.rawQuery( viewAllQuery+ TABLE_NAME,null);
        return  res;
    }


}

