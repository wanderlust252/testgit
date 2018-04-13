package com.example.niwm.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView ani;
    Handler handler;
    int i=1;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ani = (ImageView) findViewById(R.id.imageview);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what ==0){
                    if(i<18){
                        ani.setImageLevel(i++);
                    }
                    else{
                        i=1;
                    }
                }
            }
        };
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iMenu = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(iMenu);
                finish();
            }
        },3000);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },0,50);

    }
}
