package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by alexandrup on 1/8/2017.
 */

public class MySecondReceiver extends BroadcastReceiver {

    private static final String TAG = MySecondReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Hello from 2nd receiver");
        Toast.makeText(context, "Hello from 2nd receiver", Toast.LENGTH_LONG).show();
    }
}
