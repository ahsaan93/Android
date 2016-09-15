package com.example.muhammadahsan.bussinessprofile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    IntentActivity intentActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentActivity = new IntentActivity();
    }
    public void goFacebook(View view){
        Intent intent = intentActivity.facebook(getString(R.string.contact_facebook));
        startActivity(intent);
    }
    public void goTwitter(View view){
        Intent intent = intentActivity.twitter(getString(R.string.contact_twitter));
        startActivity(intent);
    }
    public void goYoutube(View view){
        Intent intent = intentActivity.youtube(getString(R.string.contact_youtube));
        startActivity(intent);
    }
    public void goEmail(View view){
        Intent intent = intentActivity.mail(getString(R.string.business_email));
        startActivity(intent);
    }
    public void goURL(View view){
        Intent intent = intentActivity.url(getString(R.string.business_web));
        startActivity(intent);
    }
    public void callMe(View view){
        Intent intent = intentActivity.call(getString(R.string.business_contact));
        startActivity(intent);
    }
}
