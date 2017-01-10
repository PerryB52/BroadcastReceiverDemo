package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by alexandrup on 1/8/2017.
 */
//creating BroadcastReceiver as stand alone class
public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG, "Hello from 1st Receiver, Thread name: " + Thread.currentThread().getName());

        Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_LONG).show();

    }

}

