package com.mykiddo.app.Activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;



public class SplashScreenActivity extends AppCompatActivity {


    private TextView tvSignUp;
    private Button btnSignIn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        getWindow().setFormat(PixelFormat.UNKNOWN);



        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
    }


