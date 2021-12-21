package com.ciu.textrecognity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class TextRecognition extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_recognition);
        Uri selectedImage = getIntent().getParcelableExtra("selected_image");
        ImageView imageSection = findViewById(R.id.imageViewShow);
        imageSection.setImageURI(selectedImage);
    }

}