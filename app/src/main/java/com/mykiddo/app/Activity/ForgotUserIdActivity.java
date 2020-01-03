package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotUserIdActivity extends AppCompatActivity {

    Button btn_forgot_user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_user_id);

        btn_forgot_user_id=(Button)findViewById(R.id.btn_forgot_user_id);

        btn_forgot_user_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotUserIdActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
