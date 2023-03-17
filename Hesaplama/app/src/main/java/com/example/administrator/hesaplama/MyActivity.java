package com.example.administrator.hesaplama;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final EditText sayi1 = (EditText) findViewById(R.id.editText);
        final EditText sayi2 = (EditText) findViewById(R.id.editText2);
        final Button toplama = (Button) findViewById(R.id.button);
        final TextView sonuc = (TextView) findViewById(R.id.textView);

        toplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1 = Integer.parseInt(sayi1.getText().toString());
                int s2 = Integer.parseInt(sayi2.getText().toString());
                int sum = s1+s2;
                sonuc.setText("Sonuc ="+ Integer.toString(sum));
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
