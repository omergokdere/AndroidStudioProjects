package com.example.administrator.broadcast_sms_ornegi;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 11.11.2014.
 */
public class MService extends Service {
    @Override
    public IBinder onBind(Intent ıntent) {
        return null;
    }
    @Override
    public void onCreate(){
        Log.i("onCreate", "Service onCreate");
        new ToastMessageTask().execute("Servis çalıştı");
        String phoneNo = "05365998179";
        String message = "TELEFON AÇILDI ARKADAŞININ";
        if(phoneNo.length()>0 && message.length()>0)
            sendSMS(phoneNo,message);
        else
            Toast.makeText(getBaseContext(),
                    "Lütfen numarayı ve mesajı yazınız",
                    Toast.LENGTH_LONG).show();

    }
    private void sendSMS(String phoneNumber, String message){
        android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber,null,message,null,null);
    }

    private class ToastMessageTask extends AsyncTask<String, String,String>{
        String toastMessage;

        @Override
        protected String doInBackground(String... params){
            toastMessage = params[0];
            return toastMessage;
        }

        protected void onPostExecute(String result){
            Toast toast = Toast.makeText(getApplicationContext(),
                    result,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
