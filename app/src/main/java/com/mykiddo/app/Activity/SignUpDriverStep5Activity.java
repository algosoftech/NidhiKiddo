package com.mykiddo.app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignUpDriverStep5Activity extends AppCompatActivity {

    Button btn_sign_up_driver_step5_next;
    TextView step5_login;
    ImageView upload_RC, rc_image;
    static final int RESULT_LOAD_IMG = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_driver_step5);

        btn_sign_up_driver_step5_next = (Button) findViewById(R.id.btn_sign_up_driver_step5_next);
        step5_login = (TextView) findViewById(R.id.step5_login);
        upload_RC = (ImageView) findViewById(R.id.upload_RC);
        rc_image = (ImageView) findViewById(R.id.rc_image);


        btn_sign_up_driver_step5_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpDriverStep5Activity.this, SignUpDriverStep6Activity.class);
                startActivity(i);
            }
        });

        step5_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpDriverStep5Activity.this, MainActivity.class);
                startActivity(i);
            }
        });


        upload_RC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                gallerypic();
                ;
            }
        });


    }

    private void gallerypic() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMG) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                rc_image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(SignUpDriverStep5Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }
    }
}

