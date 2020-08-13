package com.pritkathrotiya.thenews45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class DetailActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    TextView postTitle;
    ImageView postImage;
    HtmlTextView postDesc;
    TextView postTag;
    TextView postTime;
    ImageButton imageButton;

    Whitelist whitelist = Whitelist.relaxed();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);

        postTitle = findViewById(R.id.post_title_detail);
        postTitle.setText(getIntent().getStringExtra("postTitle"));

        postImage = findViewById(R.id.post_image_detail);
        Glide.with(this).load(getIntent().getStringExtra("postImage")).into(postImage);

        postDesc = findViewById(R.id.post_desc_detail);
        postDesc.setHtml(Jsoup.clean(getIntent().getStringExtra("postDesc"),"",whitelist.removeTags("img","src","br")));

        postTag = findViewById(R.id.post_tag);
        postTag.setText(getIntent().getStringExtra("postTag"));

        postTime = findViewById(R.id.post_time);
        postTime.setText(getIntent().getStringExtra("postTime").split("T")[0]);

        detailActivityToolbar();
    }

    public void detailActivityToolbar() {
        imageButton = findViewById(R.id.back);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

