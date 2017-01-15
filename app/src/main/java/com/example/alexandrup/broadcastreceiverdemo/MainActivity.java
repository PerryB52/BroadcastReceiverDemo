package com.example.alexandrup.broadcastreceiverdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,  "on Create init");

    }

    public void sendBroadcast(View view){
        Intent intent = new Intent("my.custom.action.name");
        sendBroadcast(intent, "my.permission");
    }
    
}
