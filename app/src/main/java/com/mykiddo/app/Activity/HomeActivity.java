package com.mykiddo.app.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView tv_forgot;
    Button btn_forgot_password;
    FrameLayout iv_myprofile,iv_transport,tv_mystudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        iv_myprofile=(FrameLayout) findViewById(R.id.iv_myprofile);



        iv_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(i);
            }
        });



        iv_transport=(FrameLayout)findViewById(R.id.iv_transport);
        tv_mystudents=(FrameLayout)findViewById(R.id.tv_mystudents);



        iv_transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, TransportActivity.class);
                startActivity(i);
            }
        });
        tv_mystudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, StudentsActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    public void onBackPressed() {
        openLogoutConfirm();
    }




    private void openLogoutConfirm() {

        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.alertbox_exit);
        TextView text_yes=dialog.findViewById(R.id.Button_Yes);
        TextView text_No=dialog.findViewById(R.id.Button_No);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        text_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        text_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
