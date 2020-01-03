package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class TransportActivity extends AppCompatActivity {

    FrameLayout iv_myRoute;
    Button btn_forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        iv_myRoute=(FrameLayout) findViewById(R.id.iv_myRoute);


//
        iv_myRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TransportActivity.this, RouteListActivity.class);
                startActivity(i);
            }
        });


    }
}
