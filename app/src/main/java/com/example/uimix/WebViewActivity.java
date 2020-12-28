package com.example.uimix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.uimix.Helpers.BottomNavigationHelper;

public class WebViewActivity extends AppCompatActivity {

    private WebView mainWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        bindViews();
        mainWebViewConfigurations();
    }

    public void bindViews(){
        mainWebView = findViewById(R.id.mainWebView);
    }

    private void mainWebViewConfigurations(){
        mainWebView.setWebViewClient(new WebViewClient());
        mainWebView.loadUrl("https://www.kastamonu.edu.tr/index.php/tr/");
    }

    public void wvExitBTNOnclickListener(View view){
        BottomNavigationHelper.shutdown(this);
    }

    public void wvNextBTNOnClickListener(View view){
        BottomNavigationHelper.next(this,ScrollViewActivity.class);
    }

}