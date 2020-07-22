package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

public class student {
    private int sid;
    private String name;
    private short age;

    public student(){
        super();
    }
    public  student(int sid,String name,short age){
        super();
        this.name=name;
        this.age=age;
        this.sid=sid;
    }
    public  int getSid(){
        return this.sid;
    }
    public  String getName(){
        return this.name;
    }
    public short getAge(){
        return this.age;
    }

    public void setSid(int sid){
        this.sid=sid;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(short age){
        this.age=age;
    }

    @NonNull
    @Override
    public String toString() {
        return "Student [sid=" + sid + ", name=" + name + ", age=" + age + "]";
    }

    //    helper=new  MyDatabaseHelper(this,"BookStore.db",null,1);//获得数据库操作类对象
}
