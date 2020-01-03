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

public class SignUpDriverStep6Activity extends AppCompatActivity {

    Button btn_sign_up_driver_step6_next;
    TextView step6_login;
    ImageView rc_image, atteched, police_image,pollution_image,upload_police,upload_pollution;
    static final int RESULT_LOAD_IMG = 100;
    static final int RESULT_LOAD_IMG2 = 200;
    static final int RESULT_LOAD_IMG3 = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_driver_step6);

        btn_sign_up_driver_step6_next = (Button) findViewById(R.id.btn_sign_up_driver_step6_next);
        step6_login = (TextView) findViewById(R.id.step6_login);


        step6_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpDriverStep6Activity.this, MainActivity.class);
                startActivity(i);
            }
        });


        rc_image = (ImageView) findViewById(R.id.rc_image);
        police_image = (ImageView) findViewById(R.id.police_image);
        pollution_image = (ImageView) findViewById(R.id.pollution_image);
        atteched = (ImageView) findViewById(R.id.atteched);
        upload_police = (ImageView) findViewById(R.id.upload_police);
        upload_pollution = (ImageView) findViewById(R.id.upload_pollution);
        atteched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                gallerypic();

            }
        });
        upload_police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                policeCopy();

            }
        });
        upload_pollution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                PolluctionCopy();
            }
        });


    }

    private void gallerypic() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

    }
    private void policeCopy() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG2);

    }
    private void PolluctionCopy() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG3);

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
                Toast.makeText(SignUpDriverStep6Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else if (requestCode == RESULT_LOAD_IMG2) {
            try {
                final Uri imageUri2 = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri2);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                police_image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(SignUpDriverStep6Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else if (requestCode == RESULT_LOAD_IMG3) {
            try {
                final Uri imageUri3 = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri3);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                pollution_image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(SignUpDriverStep6Activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    }

}