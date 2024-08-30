package com.example.chatguru;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatguru.utils.FirebaseUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        boolean isFirstTime = sharedPreferences.getBoolean("isFirstTime", true);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        if (isFirstTime) {
            // If it's the first time, open the second activity

                    Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                    startActivity(intent);


            // Mark that the app has been opened once
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();
        } else if (FirebaseUtil.isLoggedIn()) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            // If it's not the first time, open the third activity
            Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
            startActivity(intent);
        }

        finish();

            }
        },2000);

    }
}