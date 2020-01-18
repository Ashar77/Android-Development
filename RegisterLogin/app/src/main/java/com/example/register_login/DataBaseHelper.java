package com.example.register_login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registerUser.db";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "userName";
    public static final String COL_3 = "password";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT" + ")";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String exi = "DROP TABLE IF EXISTS";

        sqLiteDatabase.execSQL(exi+TABLE_NAME);

        onCreate(sqLiteDatabase);

    }



    public long addUser(String user,String password){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("username",user);

        contentValues.put("password",password);

        long res = db.insert("registeruser",null,contentValues);

        db.close();

        return res;

    }


    public boolean checkUser(String username,String password){

        String [] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "m?"+ "and" + COL_3 + "m";
        String [] selectionArgs = {username,password};

        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);

        int count = cursor.getCount();

        cursor.close();

        if (count>0) {
            return true;
        }

        else
            return false;


    }



}
