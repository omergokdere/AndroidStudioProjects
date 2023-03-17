package com.example.todo_list;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {



    Button b1,b2;
    EditText e1;
    String text,u;
    String un[]={"","","","","","","","","","","","","","",""};
    String pas;
    Cursor c;
    int i=0;
    String s,sqlquery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText1);

        //İŞ EKLEME...

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                ///GÖREV HAKKINDA
                text=e1.getText().toString();

                //BİR VERİTABANINDAN DB OLUŞTURMA
                // todo is our database name AND

                SQLiteDatabase db=openOrCreateDatabase("todo", Context.MODE_WORLD_WRITEABLE, null);

                text="'"+text+"'";

                //TABLO YARATMAK
                s="CREATE TABLE if not exists TODOLIST"+" ("+ "list" +" VARCHAR(100)"+");";
                db.execSQL(s);

                // SORGUYA TABLO EKLEMEK
                sqlquery="INSERT INTO TODOLIST"+ " VALUES"+"("+text+");";
                db.execSQL(sqlquery);
                e1.setText("");

                Toast.makeText(getApplicationContext(), "TASK ADDED IN LIST", Toast.LENGTH_SHORT).show();
            }
        });


        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),Detail.class));
            }
        });
    }
}