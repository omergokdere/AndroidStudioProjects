package com.example.administrator.sensorlistesi;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        final TextView sensorListesi = (TextView) findViewById(R.id.textView);
        StringBuilder stringBuilder = new StringBuilder();
        for(Sensor sensor:sensorList){
            stringBuilder.append("Ad: "+sensor.getName()+"\n");
            stringBuilder.append("Tip: "+sensor.getType()+"\n");
            stringBuilder.append("Uretici: "+sensor.getVendor()+"\n");
            stringBuilder.append("Versiyon: "+sensor.getVersion()+"\n");
            stringBuilder.append("Maksimum Aralık: "+sensor.getMaximumRange()+"\n");
            stringBuilder.append("Güç: "+sensor.getPower()+"\n");
            stringBuilder.append("\n");
        }
        sensorListesi.setText(stringBuilder.toString());

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
