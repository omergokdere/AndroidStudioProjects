package com.example.todo_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Detail extends Activity {

    Button b, clr;
    ListView lv;
    String query;
    Cursor c;
    String uns[] = { "", "", "", "", "", "", "","","",""};
    int i = 0;
    int t = 0;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        b = (Button) findViewById(R.id.btn);
        clr = (Button) findViewById(R.id.clear);
        lv = (ListView) findViewById(R.id.listView1);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, uns);

        db = openOrCreateDatabase("todo", Context.MODE_WORLD_READABLE, null);


        c = db.rawQuery("SELECT * FROM TODOLIST; ", null);
        i = 0;
        while (c.moveToNext()) {

            uns[i] = c.getString(0);
            i++;
        }
        t = i;

        lv.setAdapter(adapter);

        // VERİLERİ SİLMEK
        clr.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                db = openOrCreateDatabase("todo", Context.MODE_WORLD_WRITEABLE,
                        null);

                //SORGUDAKİ TÜM VERİLERİ SİLER
                db.delete("TODOLIST", null, null);

                db.close();

                for (int j = 0; j < t; j++) {
                    uns[j] = "";
                    lv.setAdapter(adapter);
                }

            }
        });

        // MAIN ACTIVITY DÖNÜŞ
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getApplicationContext(),
                        MainActivity.class));
            }
        });


    }

}