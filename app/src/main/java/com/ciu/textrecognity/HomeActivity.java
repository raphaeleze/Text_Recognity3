package com.ciu.textrecognity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

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
       Button cam = findViewById(R.id.btnTextrecognity);
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE);
            ImageView imageSection = findViewById(R.id.imageViewshow);
            imageSection.setImageURI(selectedImage);
            Intent intent_gallery = new Intent(HomeActivity.this, TextRecognition.class);
            startActivity(intent_gallery);
        });


        //OPEN CAMERA

       /* gallery.setOnClickListener(v -> {
            Intent intent_cam = new Intent();
            intent_cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent_cam);
        });*/

}

    //GETTING IMAGE FROM GALLERY

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==RESULT_OK && requestCode == PICK_IMAGE){
            selectedImage= data.getData(); }
    }




}

