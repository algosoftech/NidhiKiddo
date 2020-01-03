package com.mykiddo.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpStep2Activity extends AppCompatActivity {

    Button btn_sign_up_step2_next;
    TextView step2_login;
    LinearLayout linearLayout,linear_container,linear_name,linear_last;
    RelativeLayout relativeLayout;
    View childView,SpinnerView;
    ImageView imageView,spinner_image;
    Spinner spinner;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_step2);
        linear_container = findViewById(R.id.Linear_signUp2);







//        btn_sign_up_step2_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignUpStep2Activity.this, SignUpstudentStep3Activity.class);
//                startActivity(i);
//            }
//        });

//        step2_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignUpStep2Activity.this, MainActivity.class);
//                startActivity(i);
//            }
//        });


    }

    private void AddFields(int index){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        childView = inflater.inflate(R.layout.form_field, null); //question layout
        imageView = childView.findViewById(R.id.Image_Name);
        editText = childView.findViewById(R.id.Edit_FirstName);
        linear_name = childView.findViewById(R.id.Edit_LinearName);
        childView.setId(index);
        linearLayout.setId(index);
        imageView.setId(index);
        imageView.setImageResource(R.drawable.person);
        editText.setId(index);
        editText.setHint("Name");
        if (index==0){
            linear_last.setVisibility(View.VISIBLE);
        }else {
            linear_last.setVisibility(View.GONE);
        }

    }

    private void addDropDown(){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SpinnerView = inflater.inflate(R.layout.spinner_layout, null);
        spinner_image = SpinnerView.findViewById(R.id.Image_view);
        spinner = SpinnerView.findViewById(R.id.Spinner);





    }
}
