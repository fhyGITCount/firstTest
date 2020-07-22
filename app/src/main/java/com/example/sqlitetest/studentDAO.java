package com.example.sqlitetest;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.AndroidException;

import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public  studentDAO(Context context) {
        helper = new MyDatabaseHelper(context);
    }
    public void add(student stu){
        db=helper.getWritableDatabase();//db 为操作数据库的实例
        String sql="insert into t_student(sid,name,age) values(?,?,?)";
        db.execSQL(sql,new Object[]{
            stu.getSid(),stu.getName(),stu.getAge()
        });

    }
    public void delete(Integer... sids){
        if(sids.length>0){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<sids.length;i++){
                sb.append('?').append('?');
            }
            sb.deleteCharAt(sb.length()-1);
            SQLiteDatabase database=helper.getWritableDatabase();
            String sql="delete  from t_student where sid in("+sb+")";
            database.execSQL(sql, (Object[])sids);
        }
    }

    public void updata(student stu){
        db=helper.getWritableDatabase();
        String sql="update t_student(sid,name,age) values(?,?,?)";
        db.execSQL(sql,new Object[]{
                stu.getSid(),stu.getName(),stu.getAge()
        });
    }
    public student query(int sid) {

        db = helper.getWritableDatabase();

        String sql = "select sid,name,age from t_student where sid=?";

// Cursor实际上就是一种存储数据的集合

        Cursor cursor = db.rawQuery(sql, new String[] { String.valueOf(sid) });

// 在cursor查找到的结果集合中将光标移动到到下一行，也就是将光标指向查找到的下一个结果

        if (cursor.moveToNext()) {

// 通过getColumnIndex()方法可以得到指定列的名称，如果不存在返回-1

            return new student(cursor.getInt(cursor.getColumnIndex("sid")),

                    cursor.getString(cursor.getColumnIndex("name")),

                    cursor.getShort(cursor.getColumnIndex("age")));

        }

        return null;

    }
    public List<student> getScrollData(int start, int count) {

        List<student> students = new ArrayList<student>();

        db = helper.getWritableDatabase();

        String sql = "select * from t_student limit ?,?";

        Cursor cursor = db.rawQuery(sql, new String[] { String.valueOf(start),

                String.valueOf(count) });

        while (cursor.moveToNext()) {

            students.add(new student(

                    cursor.getInt(cursor.getColumnIndex("sid")),

                    cursor.getString(cursor.getColumnIndex("name")),

                    cursor.getShort(cursor.getColumnIndex("age"))));

        }

        return students;
    }

    public long getCount(){

        db=helper.getWritableDatabase();

        String sql="select count(sid) from t_student";

        Cursor cursor=db.rawQuery(sql,null);

        if(cursor.moveToNext()){

            return cursor.getLong(0);

        }

        return 0;

    }

}
