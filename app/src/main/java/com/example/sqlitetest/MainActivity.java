package com.example.sqlitetest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public Button btnCreate;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnChange;
    public Button btnFind;
    private MyDatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate=findViewById(R.id.button2);
        btnAdd=findViewById(R.id.button3);
        btnDelete=findViewById(R.id.button4);
        btnChange=findViewById(R.id.button5);
        btnFind=findViewById(R.id.button6);

        MyClickListener listener=new MyClickListener();
        btnCreate.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
        btnChange.setOnClickListener(listener);
        btnFind.setOnClickListener(listener);
    }

    public class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.button2)
            {

                Log.i("button","test");
            }
            if(v.getId()==R.id.button3)
            {
                testAdd();
            }
            if(v.getId()==R.id.button4)
            {
                testDelete();
            }
            if(v.getId()==R.id.button5)
            {

            }
            if(v.getId()==R.id.button6)
            {

            }
        }

    }
    public void testAdd(){
        studentDAO sdao = new studentDAO(this);
        student stu = new student(1,"zhangsan",(short)23);
        sdao.add(stu);
        Log.i("--", "添加学生成功");
    }

    //测试修改方法
    public void testUpdate(){
        studentDAO sdao = new studentDAO(MainActivity.this);
//        student stu = sdao.findstudentById(1);
//        stu.setSname("lisi");
//        sdao.update(stu);
//        Log.i(TAG, "修改学生信息成功");
    }

    //测试根据id查找学生方法
    public void testFindstudentById(){
        studentDAO sdao = new studentDAO(MainActivity.this);
//        student stu = sdao.findstudentById(1);
//        if(stu == null){
//            Log.i(TAG, "not find");
//        }else{
//            Log.i(TAG, stu.toString());
//        }
    }

    //测试删除方法
    public void testDelete(){
        studentDAO sdao = new studentDAO(MainActivity.this);
        sdao.delete(1,2);
        Log.i("--", "删除成功");
    }

    //测试获取总人数的方法
    public void testGetCount(){
        studentDAO sdao = new studentDAO(MainActivity.this);
        long count = sdao.getCount();
        Log.i("--", count+"");
    }

    //测试分页方法
    public void testGetstudent(){
        studentDAO sdao = new studentDAO(MainActivity.this);
//        List<student> lists = sdao.getstudent(0, 1);
//        for (student s : lists) {
//            Log.i("--", s.toString());
        }
    }


