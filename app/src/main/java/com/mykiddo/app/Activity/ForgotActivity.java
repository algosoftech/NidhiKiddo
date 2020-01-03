package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {

    TextView tv_forgot;
    Button btn_forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btn_forgot_password=(Button)findViewById(R.id.btn_forgot_password);





    }
}
