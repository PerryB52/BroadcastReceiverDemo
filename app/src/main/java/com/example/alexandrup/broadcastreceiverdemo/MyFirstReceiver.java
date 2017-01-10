package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

        if (isOrderedBroadcast()) {
            int initCode = getResultCode();
            String initData = getResultData();
            Bundle initBundle = getResultExtras(true);
            String title = initBundle.getString("title");

            Log.i(TAG, "Code: " + initCode + ", Data: " + initData + ", Bundle: " + title);


            Log.i(TAG, "Hello from 1st Receiver, Thread name: " + Thread.currentThread().getName());

            Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_LONG).show();


            initBundle.putString("title", "LazyDev");
            setResult(83, "Windows", initBundle);

        }

    }
}
