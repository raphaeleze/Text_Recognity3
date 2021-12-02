package com.ciu.textrecognity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLACH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void  run() {
                Intent homeInternt = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeInternt);
                finish();

            }

        },SPLACH_TIME_OUT);
    }
}