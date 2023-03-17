package com.example.administrator.menu1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


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
        menu.add(menu.NONE,Menu.FIRST,0,"Geri Dön");
        menu.add(menu.NONE,Menu.FIRST+1,1,"Evi Ara");
        menu.add(menu.NONE,Menu.FIRST+2,2,"Web Tarayıcıyı Aç");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView mesaj =(TextView) findViewById(R.id.textView);
        switch(id)
        {
            case 1:mesaj.setText("GERI DÖNÜYOR MENUSU SECILDI");
                return true;
            case 2:
                mesaj.setText("Ev Aranıyor...");
                Intent arama = new Intent(Intent.ACTION_DIAL);
                arama.setData(Uri.parse("tel:05327777777"));
                startActivity(arama);
                return true;
            case 3: Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("http://www.bjk.org.tr"));
                startActivity(browser);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
