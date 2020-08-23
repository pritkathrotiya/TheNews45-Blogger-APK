package com.pritkathrotiya.thenews45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void openFacebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100008127971842"));
        try {
            getBaseContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            startActivity(intent);
        }
        catch (ActivityNotFoundException | PackageManager.NameNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100008127971842")));
        }
    }

    public void openInstagram(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/_u/pritkathrotiya"));
        try {
            getBaseContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
            startActivity(intent);
        }
        catch (ActivityNotFoundException | PackageManager.NameNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/pritkathrotiya/")));
        }
    }

    public void openWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thenews45.blogspot.com/"));
        startActivity(intent);
    }

    public void openTwitter(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://thenews45blog?s=01"));
        try {
            getBaseContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
            startActivity(intent);
        }
        catch (ActivityNotFoundException | PackageManager.NameNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/thenews45blog")));
        }
    }

    public void openGithub(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pritkathrotiya"));
        startActivity(intent);
    }
}