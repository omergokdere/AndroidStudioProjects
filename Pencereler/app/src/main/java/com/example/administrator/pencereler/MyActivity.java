package com.example.administrator.pencereler;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final EditText user = (EditText) findViewById(R.id.editText);
        final EditText pass = (EditText) findViewById(R.id.editText2);
        final Button aktar = (Button) findViewById(R.id.button);
        final Button tarayici = (Button) findViewById((R.id.button2));
        final Button ara =(Button)findViewById(R.id.button3);


        aktar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aktarim =new Intent(MyActivity.this,pencereler2.class);
                aktarim.putExtra("Kullanici",user.getText().toString());
                aktarim.putExtra("Password",pass.getText().toString());
                startActivity(aktarim);
            }
        });

        tarayici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW);
                browser.setData(Uri.parse("http://www.maltepe.edu.tr"));
                startActivity(browser);
            }
        });
        ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arama = new Intent(Intent.ACTION_DIAL);
                arama.setData(Uri.parse("tel:5327777777"));
                startActivity(arama);
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
