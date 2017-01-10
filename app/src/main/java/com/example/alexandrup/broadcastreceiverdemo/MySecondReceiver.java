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

public class MySecondReceiver extends BroadcastReceiver {

    private static final String TAG = MySecondReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {


        if (isOrderedBroadcast()) {
            int initCode = getResultCode();
            String initData = getResultData();
            Bundle initBundle = getResultExtras(true);
            String title = initBundle.getString("title");

            Log.i(TAG, "Code: " + initCode + ", Data: " + initData + ", Bundle: " + title);

            Log.i(TAG, "Hello from 2nd receiver");
            Toast.makeText(context, "Hello from 2nd receiver", Toast.LENGTH_LONG).show();

            initBundle.putString("title", "CleverDeveloper");
            setResult(47, "Blackberry", initBundle);

            // do not commit until we find out what is not working

        }
    }
}
