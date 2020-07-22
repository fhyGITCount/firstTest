package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import android.util.Log;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

//    private  static  final String CREATE_BOOK="create table book (" + "id integer primary key autoincrement," + "author text, " + "price real, " + "pages integer, " + "name text)";

    String sql="create table t_student(sid integer primary key,"+"name varchar(20),"+"age integer)";
    private  static  final  int version=1;
    private  static  final String name="data.db";
    private  static  SQLiteDatabase.CursorFactory factory=null;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, name, factory, version);
        //context=this.context;//返回this.context 作为创建对象时的context参数,可直接传入this.context；

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        Log.i("DataBases Create","SUCCESS");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}//基本的类完成 简单创建一个
