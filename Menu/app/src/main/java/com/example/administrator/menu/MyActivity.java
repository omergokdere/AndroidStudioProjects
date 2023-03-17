package com.example.administrator.menu;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        menu.add(menu.NONE, menu.FIRST,3,"GERİ DÖN");
        menu.add(menu.NONE, menu.FIRST+1,4,"Evi Ara");
        menu.add(menu.NONE, menu.FIRST+2,5,"Web tarayıcıyı aç");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        TextView mesaj = (TextView) findViewById(R.id.textView);
        int id = item.getItemId();

        switch(id){
            case 1:mesaj.setText("Geri Dönüyor...");
                return true;
            case 2:
                Intent arama = new Intent(Intent.ACTION_DIAL);
                arama.setData(Uri.parse("tel:5327777777"));
                startActivity(arama);
                return true;
            case 3:
                Intent browser=new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("http://www.maltepe.edu.tr"));
                startActivity(browser);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
        //return super.onOptionsItemSelected(item);
    }
}
