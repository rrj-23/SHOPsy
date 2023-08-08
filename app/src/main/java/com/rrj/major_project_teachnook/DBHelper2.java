package com.rrj.major_project_teachnook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper2 extends SQLiteOpenHelper {
    public static final String DBNAME = "cart.db";
    public DBHelper2(Context context) {
        super(context,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cart(name Text,brand TEXT,image INTEGER primary key,price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists cart");
    }

    public Boolean insertDataCart(String name,String brand, int image,String price){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put ("brand",brand );
        values.put ("image", image);
        values.put ("price", price);
        long result = db.insert("cart",null,values);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getCartData(String name,String brand,int image, String price){
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart",null);
        return c;
    }

    public void deleteTable(){
        SQLiteDatabase db =  this.getWritableDatabase();
        db.execSQL("drop table cart");
        onCreate(db);
    }
    public int getCount(){
        SQLiteDatabase db =  this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart",null);
        return c.getCount();
    }

//    public int getCountItem(int image){
//        SQLiteDatabase db =  this.getReadableDatabase();
//        Cursor c = db.rawQuery("select * from cart where image = ?",null);
//        return c.getCount();
//    }


}
