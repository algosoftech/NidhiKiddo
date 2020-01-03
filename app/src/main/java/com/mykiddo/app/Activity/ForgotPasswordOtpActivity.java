package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordOtpActivity extends AppCompatActivity {

    TextView tv_forgot;
Button btn_forgot_password_otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_otp);

        btn_forgot_password_otp=(Button)findViewById(R.id.btn_forgot_password_otp);

        btn_forgot_password_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotPasswordOtpActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });



    }
}
