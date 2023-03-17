package com.example.administrator.sensoruygulamasi1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MyActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor ivmeSensoru;
    private TextView sonuc;
    float ivmedegeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        ivmeSensoru = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sonuc = (TextView)findViewById(R.id.textView);
        sonuc.setText(String.valueOf(ivmedegeri));
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

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        sonuc.setText("X: "+ String.valueOf(sensorEvent.values[0])+"\n"+
        "Y: "+String.valueOf(sensorEvent.values[1])+"\n"+
        "Z: "+String.valueOf(sensorEvent.values[2])+"\n");

    }
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,ivmeSensoru,sensorManager.SENSOR_DELAY_NORMAL);

    }
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
