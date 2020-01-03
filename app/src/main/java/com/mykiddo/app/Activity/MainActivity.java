package com.mykiddo.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mykiddo.app.AppPermissionClass;
import com.mykiddo.app.R;

public class MainActivity extends AppCompatActivity {

    TextView tv_forgot,tv_forgot_user_id,tv_sign_up;
    Button btn_login;
    RadioButton radio_password,radio_pin;
    private static final int PERMISSION_ALL = 111;
    EditText ed_userId,ed_password;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_userId=(EditText)findViewById(R.id.ed_userId);
        ed_password=(EditText)findViewById(R.id.ed_userId);
        tv_forgot=(TextView)findViewById(R.id.tv_forgot);
        tv_forgot_user_id=(TextView)findViewById(R.id.tv_forgot_user_id);
        radio_password=(RadioButton)findViewById(R.id.radio_password);
        radio_pin=(RadioButton)findViewById(R.id.radio_pin);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        radio_password.setSelected(true);

        String[] PERMISSIONS = {
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        AppPermissionClass appPermissionClass = new AppPermissionClass();
        if(!appPermissionClass.hasPermissions(MainActivity.this,PERMISSIONS)){
            ActivityCompat.requestPermissions(this,PERMISSIONS,PERMISSION_ALL);
        }

        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ForgotActivity.class);
                startActivity(i);
            }
        });
        tv_forgot_user_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ForgotUserIdActivity.class);
                startActivity(i);
            }
        });

        tv_sign_up=(TextView)findViewById(R.id.tv_sign_up);
        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

        btn_login=(Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_Id = ed_userId.getText().toString();
                String pass = ed_password.getText().toString();

                if(user_Id.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter  User Id",Toast.LENGTH_LONG).show();
                }else if(pass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                }else if(radioGroup.isSelected()){
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                } else {

                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);
                }



            }
        });
    }
}

