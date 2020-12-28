package com.example.uimix.Helpers;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.uimix.ScrollViewActivity;

public class BottomNavigationHelper {

    public static void previous(FragmentActivity activity) {
        activity.finish();
        activity.onBackPressed();
    }

    public static void next(FragmentActivity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

    public static void shutdown(FragmentActivity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("Çıkış yapılıyor..")
                .setMessage("Uygulamadan çıkış yapmak istediğinize emin misiniz?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Boş
                    }
                })
                .create().show();

    }
}
