package com.example.alexandrup.broadcastreceiverdemo;

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

        //Intent intent = new Intent(this, MyFirstReceiver.class);
        Intent intent = new Intent("my.custom.action.name");

        intent.putExtra("name", "Alexandru Pereteanu");
        intent.putExtra("age", 27);

        sendBroadcast(intent);

    }

    public void broadcastToInnerReceiver(View view) {

        //Intent intent = new Intent(this, MyThirdReceiverInner.class);
        Intent intent = new Intent("my.custom.anotheraction.name");

        Bundle bundle = new Bundle();
        bundle.putString("name", "Alex Alex");
        bundle.putInt("age", 22);


        intent.putExtras(bundle);
        sendBroadcast(intent);

    }

    //creating BroadcastReceiver as inner class
    public static class MyThirdReceiverInner extends BroadcastReceiver{

        private final String TAG = MyThirdReceiverInner.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent) {

            String name = intent.getStringExtra("name");
            int age = intent.getIntExtra("age", 0);
            Log.i(TAG, "Name: " + name + ", Age: "  + age);

            Log.i(TAG, "Hello from 3rd receiver");
            Toast.makeText(context, "Hello from 3rd Receiver", Toast.LENGTH_LONG).show();
        }
    }
}
