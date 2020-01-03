package com.mykiddo.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpstudentStep4Activity extends AppCompatActivity {

    Button btn_sign_up_student_step4_next;

    TextView step4_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student_step4);

        btn_sign_up_student_step4_next=(Button) findViewById(R.id.btn_sign_up_student_step4_next);


        btn_sign_up_student_step4_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpstudentStep4Activity.this, SignUpDriverStep5Activity.class);
                startActivity(i);
            }
        });
        step4_login=(TextView) findViewById(R.id.step4_login);

        step4_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpstudentStep4Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
