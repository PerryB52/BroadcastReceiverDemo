package com.example.alexandrup.broadcastreceiverdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
    }

    public void sendBroadcastMessage(View view) {


        Intent intent = new Intent("my.custom.action.name");

        //sendBroadcast(intent);
        //sendOrderedBroadcast(intent, null);

        Bundle b = new Bundle();
        b.putString("title", "SmartDeveloper");

        sendOrderedBroadcast(intent, null, new MyFourthReceiver(), null, Activity.RESULT_OK, "Android", b);
    }

    //creating BroadcastReceiver as inner class
    public static class MyThirdReceiverInner extends BroadcastReceiver {

        private final String TAG = MyThirdReceiverInner.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent) {

            if (isOrderedBroadcast()) {
                int initCode = getResultCode();
                String initData = getResultData();
                Bundle initBundle = getResultExtras(true);
                String title = initBundle.getString("title");

                Log.i(TAG, "Code: " + initCode + ", Data: " + initData + ", Bundle: " + title);

                Log.i(TAG, "Hello from 3rd receiver");
                Toast.makeText(context, "Hello from 3rd Receiver", Toast.LENGTH_LONG).show();

                setResultCode(17);
                setResultData("iOS");

                initBundle.putString("title", "WiseDeveloper");
                setResultExtras(initBundle);

            }


        }
    }
}
