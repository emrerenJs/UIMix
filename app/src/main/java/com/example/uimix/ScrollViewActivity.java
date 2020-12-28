package com.example.uimix;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uimix.Helpers.BottomNavigationHelper;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ScrollViewActivity extends AppCompatActivity {

    private TextView txtFileOutputTW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        bindViews();
        readTxtFile();
    }

    /*permissions*/
    private void readTxtFile(){
        String data = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = this.getResources().openRawResource(R.raw.test);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            while((data = bufferedReader.readLine()) != null){
                stringBuilder.append(data + "\n");
            }
            bufferedReader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            txtFileOutputTW.setText(stringBuilder.toString());
        }
    }

    /*Configurations*/
    private void bindViews(){
        txtFileOutputTW = findViewById(R.id.txtFileOutputTW);
    }

    /*OnClick Listeners*/
    public void swBackBTNOnClickListener(View view){
        BottomNavigationHelper.previous(this);
    }

    public void swExitBTNOnClickListener(View view){
        BottomNavigationHelper.shutdown(this);
    }

    public void swNextBTNOnClickListener(View view){
        BottomNavigationHelper.next(this,MapsViewActivity.class);
    }

}