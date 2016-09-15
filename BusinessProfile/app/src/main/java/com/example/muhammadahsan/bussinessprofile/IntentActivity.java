package com.example.muhammadahsan.bussinessprofile;

import android.content.Intent;
import android.net.Uri;

public class IntentActivity {
    public Intent facebook(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(v));
        return intent;
    }
    public Intent twitter(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(v));
        return intent;
    }
    public Intent youtube(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(v));
        return intent;
    }
    public Intent url(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+v));
        return intent;
    }
    public Intent mail(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+v));
        return intent;
    }
    public Intent call(String v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+v));
        return intent;
    }
}
