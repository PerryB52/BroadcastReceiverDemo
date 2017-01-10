package com.example.alexandrup.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MyFirstReceiver myFirstReceiver;
    private TextView textView;
    private int ctr = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);


        myFirstReceiver = new MyFirstReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        //intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(myFirstReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(myFirstReceiver);
    }

    public void registerReceiver(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);

        registerReceiver(timeTickReceiver,intentFilter);

    }

    public void unregisterTimer(View view) {

        unregisterReceiver(timeTickReceiver);
    }

    private BroadcastReceiver timeTickReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int minutes = ctr;
            textView.setText(minutes + " minute over");
            ctr++;

            Toast.makeText(context, "Hello from Time Tick Receiver", Toast.LENGTH_SHORT).show();
        }
    };
}
