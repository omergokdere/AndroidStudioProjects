package com.example.administrator.broadcast_ornegi2;

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
    }
    public class ToastMessageTask extends AsyncTask<String, String, String >{
        String toastmessage;

        @Override
        protected String doInBackground(String... params) {
            toastmessage =params[0];
            return toastmessage;
        }
        protected void onPostExecute(String result){
            Toast toast = Toast.makeText(getApplicationContext(),
                    result,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
