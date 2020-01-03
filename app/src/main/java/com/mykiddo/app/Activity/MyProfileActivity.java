package com.mykiddo.app.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfileActivity extends AppCompatActivity {

    TextView tv_forgot;
    Button btnsubmit;
    EditText editName, editPhoneNumber, editEmail, tv_con_password, ed_password;
    RelativeLayout rel_password, rel_con_password;
    static final int RESULT_LOAD_IMG = 100;
    static final int CAMERA_PIC_REQUEST = 200;
    ImageView upload_image;
    CircleImageView profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        btn_forgot_password=(Button)findViewById(R.id.btn_forgot_password);
//
//
//
//        btn_forgot_password.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MyProfileActivity.this,ForgotPasswordOtpActivity.class);
//                startActivity(i);
//            }
//        });


        editName = findViewById(R.id.editName);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editEmail = findViewById(R.id.editEmail);
        btnsubmit = findViewById(R.id.btnsubmit);
//        rel_con_password = findViewById(R.id.rel_con_password);
//        rel_password = findViewById(R.id.rel_password);
        profile_image = findViewById(R.id.profile_image);


        final ImageView fab = (ImageView) findViewById(R.id.edit_iv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(!isViewEditable){
//                    isViewEditable=true;
                setEditableScreen();
                fab.setVisibility(View.GONE);
//                }else {
//                }
            }

        });

        upload_image = (ImageView) findViewById(R.id.upload_image);
        upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

                final Dialog dialog = new Dialog(MyProfileActivity.this);
                dialog.setContentView(R.layout.profile_camra_type_dialog);
                TextView tv_btn_takepic = dialog.findViewById(R.id.tv_btn_takepic);
                TextView tv_btn_gallery_pic = dialog.findViewById(R.id.tv_btn_gallery_pic);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                tv_btn_takepic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        takepic();
                        dialog.dismiss();

                    }
                });
                tv_btn_gallery_pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gallerypic();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }


        });
        Button btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyProfileActivity.this, MyProfileActivity.class);
                startActivity(i);
//            }
//        });
            }

        });



        TextView rest_password = (TextView) findViewById(R.id.rest_password);
        rest_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyProfileActivity.this, ResetPasswordActivity.class);
                startActivity(i);
//            }
//        });
            }

        });



        setDefaultScreen();

    }

    private void setEditableScreen() {
        editName.setEnabled(true);
        editPhoneNumber.setEnabled(true);

        editEmail.setEnabled(false);


        btnsubmit.setVisibility(View.VISIBLE);
//        rel_con_password.setVisibility(View.VISIBLE);
//        rel_password.setVisibility(View.VISIBLE);

//        editName.setText(strName);
//        editEmail.setText(strEmail);
//        editPhoneNumber.setText(strPhone);
    }

    private void setDefaultScreen() {
        editName.setEnabled(false);
        editPhoneNumber.setEnabled(false);

        editEmail.setEnabled(false);
        btnsubmit.setVisibility(View.GONE);

//        editName.setText(strName);
//        editEmail.setText(strEmail);
//        editPhoneNumber.setText(strPhone);
    }


    private void takepic() {

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);

//
    }


    private void gallerypic() {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.profile_image); //sets imageview as the bitmap
            imageview.setImageBitmap(image);
        }else if (requestCode == RESULT_LOAD_IMG) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                profile_image.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(MyProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(MyProfileActivity.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }

        }

    }

