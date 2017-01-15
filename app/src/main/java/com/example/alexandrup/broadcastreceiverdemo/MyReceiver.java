package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by alexandrup on 1/8/2017.
 */
//creating BroadcastReceiver as stand alone class
public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = MyReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        int a = intent.getIntExtra("a",0);
        int b = intent.getIntExtra("b", 0);

        int sum = a + b;

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);

        Intent returningIntent = new Intent("my.result.intent");
        returningIntent.putExtra("sum", sum);

        localBroadcastManager.sendBroadcast(returningIntent);

    }

}

