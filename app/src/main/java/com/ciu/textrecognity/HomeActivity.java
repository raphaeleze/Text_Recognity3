package com.ciu.textrecognity;

import androidx.annotation.NonNull;
import androidx.annotation.NonUiContext;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE =100;
    Uri selectedImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //OPEN GALLERY


        Button gallery = findViewById(R.id.btnGalery);
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE);


        });


        //OPEN CAMERA


       Button cam = findViewById(R.id.btnRecognition);
       cam.setOnClickListener(v -> {
            Intent intent_cam = new Intent();
            intent_cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent_cam);
        });



    }

    //GETTING IMAGE FROM GALLERY

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==RESULT_OK && requestCode == PICK_IMAGE){
           selectedImage= data.getData();
            Intent intent_gallery = new Intent(HomeActivity.this, TextRecognition.class);
            intent_gallery.putExtra("selected_image", selectedImage);
            startActivity(intent_gallery);


        }

    }




}
