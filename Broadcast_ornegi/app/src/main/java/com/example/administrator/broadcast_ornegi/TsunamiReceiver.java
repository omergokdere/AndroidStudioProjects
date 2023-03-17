package com.example.administrator.broadcast_ornegi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 11.11.2014.
 */
public class TsunamiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent ıntent) {
        String message = ıntent.getStringExtra("MESAJ");
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
