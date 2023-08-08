package com.rrj.major_project_teachnook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "login.db";
    public DBHelper(Context context) {
        super(context,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(name TEXT, username TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String name,String username, String password){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put ("username", username);
        values.put ("password", password);
        long result = db.insert("users",null,values);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where username = ?",new String[]{username});
        if(c.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where username = ? and password = ?",new String[]{username,password});
        if(c.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Cursor getName1(String username){
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor c = db.rawQuery("select name from users where username = ?",new String[]{username});
//        System.out.println(c.getCount());
        return c;
    }


}
