package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpstudentStep3Activity extends AppCompatActivity {

    Button btn_sign_up_student_step3_next;
TextView step3_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student_step3);

        btn_sign_up_student_step3_next=(Button) findViewById(R.id.btn_sign_up_student_step3_next);
        step3_login=(TextView) findViewById(R.id.step3_login);


        btn_sign_up_student_step3_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpstudentStep3Activity.this, SignUpstudentStep4Activity.class);
                startActivity(i);
            }
        });


        step3_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpstudentStep3Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
