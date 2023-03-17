package com.example.administrator.broadcast_sms_ornegi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 11.11.2014.
 */
public class MReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent ıntent) {
        Intent myIntent = new Intent(context,MService.class);
        context.startService(myIntent);

    }
}
