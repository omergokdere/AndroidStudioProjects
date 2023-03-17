package com.example.administrator.harita;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final String gpsAcildi = "GPS Açıldı";
        final String gpsKapatildi = "GPS Kapalı";
        final TextView konumText = (TextView) findViewById(R.id.textView);
        LocationManager konumYoneticisi = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener konumDinleyicisi = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                location.getLatitude();
                location.getLongitude();

                String Text = "Bulunduğumuz konum bilgileri: \n" + "Latitude= " + location.getLatitude()+
                        "\n Longitude = "+ location.getLongitude();
                konumText.setText(Text);

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {
                Toast.makeText(getApplicationContext(),gpsAcildi, Toast.LENGTH_SHORT).show();
                konumText.setText("GPS Veri Bilgileri Alınıyor");
            }

            @Override
            public void onProviderDisabled(String s) {
                Toast.makeText(getApplicationContext(),gpsKapatildi,Toast.LENGTH_SHORT).show();
                konumText.setText("GPS Kapatıldı");

            }
        };
        konumYoneticisi.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,konumDinleyicisi);
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
