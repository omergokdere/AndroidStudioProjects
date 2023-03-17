package com.example.administrator.vtuygulama;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
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
        final Button kaydet = (Button) findViewById(R.id.button);
        final TextView sonuc = (TextView) findViewById(R.id.textView2);
        final Button listele = (Button) findViewById(R.id.button2);
        final Button sil = (Button) findViewById(R.id.button3);
        v1 = new DatabaseHelper(this);
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues veriler = new ContentValues();
                veriler.put("ad",ad.getText().toString());
                veriler.put("soyad",soyad.getText().toString());
                SQLiteDatabase db = v1.getWritableDatabase();
                db.insert(DatabaseHelper.TABLE_NAME,null,veriler);
                mesaj.setText("Kayıt yapıldı");

            }
        });
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = v1.getReadableDatabase();
                String selectQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_NAME;
                try{
                    db.beginTransaction();
                    Cursor cursor;
                    cursor = db.rawQuery(selectQuery, null);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        sonuc.setText(sonuc.getText().toString()+"-"+cursor.getString(0)+cursor.getString(1)+"\n");
                        cursor.moveToNext();
                    }
                    //db.execSQL();
                    db.setTransactionSuccessful();
                }catch (Exception e){
                    e.printStackTrace();
                    db.endTransaction();
                }



            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = v1.getWritableDatabase();
                String isim = ad.getText().toString();
                try{
                    db.beginTransaction();
                    db.execSQL("DELETE * FROM personel WHERE ad='senol'");
                    db.setTransactionSuccessful();

                }catch (Exception e){
                    e.printStackTrace();
                    db.endTransaction();
                }
                mesaj.setText("silindi");
                db.close();
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
