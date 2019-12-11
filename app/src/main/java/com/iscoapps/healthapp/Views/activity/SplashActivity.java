package com.iscoapps.healthapp.Views.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.iscoapps.healthapp.R;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler;
    private ConstraintLayout layout;

    //------------ reference of views -------------------//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash_screen);

        layout = findViewById(R.id.container);

        Bundle bundle = getIntent().getExtras();

        mHandler = new Handler();

        checkPermissions();
    }

    private void initialize() {
        mHandler.postDelayed(new Runnable() {
            public void run() {

                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                // set the new task and clear flags
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();


            }
        }, 3000);
    }

    private int getUserId() {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx", Context.MODE_PRIVATE);

        return Integer.valueOf(sharedPreferences.getString("user_id", "-1"));
    }

    public void deleteCache(Context context) {
//        try {
        File dir = context.getCacheDir();
        if (dir != null && dir.isDirectory()) {
            deleteDir(dir);
        }
//        } catch (Exception e) {
//            Log.e("exception" , e.getMessage());
//        }
    }

    public boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public void checkPermissions() {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat
                    .requestPermissions(
                            this,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            0);
        } else {
            initialize();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        initialize();

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
