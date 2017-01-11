package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,  "on Create init");

    }

    public void methodOne(View view){

        Log.i(TAG,  "Test Method one init");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        //to retrieve stick broadcast we do not need a receiver
        Intent intent = registerReceiver(null, intentFilter);

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        if(status == BatteryManager.BATTERY_STATUS_CHARGING){
            Toast.makeText(this, "Battery getting charged", Toast.LENGTH_SHORT).show();
        }

        if(status == BatteryManager.BATTERY_STATUS_DISCHARGING){
            Toast.makeText(this, "Battery getting Dischaged", Toast.LENGTH_SHORT).show();
        }

        if(status == BatteryManager.BATTERY_STATUS_FULL){
            Toast.makeText(this, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
        }

        Log.i(TAG, status + "");
    }

    public void methodTwo(View view){

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);


        registerReceiver(batterryStatusReceiver, intentFilter);

    }


    private BroadcastReceiver batterryStatusReceiver = new BroadcastReceiver() {

        private static final String TAG = "Main Charger Receiver";
        @Override
        public void onReceive(Context context, Intent intent) {


            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

            if(status == BatteryManager.BATTERY_STATUS_CHARGING){
                Toast.makeText(context, "Battery getting charged", Toast.LENGTH_SHORT).show();
            }

            if(status == BatteryManager.BATTERY_STATUS_DISCHARGING){
                Toast.makeText(context, "Battery getting Dischaged", Toast.LENGTH_SHORT).show();
            }

            if(status == BatteryManager.BATTERY_STATUS_FULL){
                Toast.makeText(context, "Battery Fully Charged", Toast.LENGTH_SHORT).show();
            }

            Log.i(TAG, status + "");
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batterryStatusReceiver);
    }
}
