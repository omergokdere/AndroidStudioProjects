package com.example.administrator.vtuygulama1;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    DatabaseHelper v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final EditText ad = (EditText) findViewById(R.id.editText);
        final EditText soyad = (EditText) findViewById(R.id.editText2);
        final TextView mesaj = (TextView) findViewById(R.id.textView);
        final TextView sonuc = (TextView) findViewById(R.id.textView2);
        final Button kaydet = (Button) findViewById(R.id.button);
        final Button liste = (Button) findViewById(R.id.button2);
        v1 = new DatabaseHelper(this);
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues veriler = new ContentValues();
                veriler.put("ad",ad.getText().toString());
                veriler.put("soyad",soyad.getText().toString());
                SQLiteDatabase db = v1.getWritableDatabase();
                db.insert(DatabaseHelper.TABLE_NAME,null,veriler);
                mesaj.setText("Kayıt yapıldı...");

            }
        });
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = v1.getReadableDatabase();
                db.execSQL("SELECT * FROM"+DatabaseHelper.TABLE_NAME);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
