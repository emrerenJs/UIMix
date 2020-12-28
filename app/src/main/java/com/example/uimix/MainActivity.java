package com.example.uimix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        next();
    }

    private void bindViews() {
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
    }

    private void next(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splashscreen_animation);
        textView.startAnimation(animation);
        imageView.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }

}