package com.pritkathrotiya.thenews45;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    TextView postTitle;
    ImageView postImage;
    TextView postDesc;
    TextView postUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);

        postImage = findViewById(R.id.post_image_detail);
        Glide.with(this).load(getIntent().getStringExtra("postImage")).into(postImage);

        postTitle = findViewById(R.id.post_title_detail);
        postTitle.setText(getIntent().getStringExtra("postTitle"));

        postDesc = findViewById(R.id.post_desc_detail);
        postDesc.setText(getIntent().getStringExtra("postDesc"));
    }
}
