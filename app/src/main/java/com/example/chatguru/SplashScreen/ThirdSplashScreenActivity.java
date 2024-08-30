package com.example.chatguru.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.chatguru.R;
import com.example.chatguru.SignUpActivity;

public class ThirdSplashScreenActivity extends AppCompatActivity {

    AppCompatButton NextSplashBtn;

    TextView Skipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_splash_screen);


        NextSplashBtn = findViewById(R.id.splashbtn_2);
        Skipbtn = findViewById(R.id.skip2);

        NextSplashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThirdSplashScreenActivity.this, FourthSplashScreenActivity.class));
                finish();
            }
        });

        Skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThirdSplashScreenActivity.this, SignUpActivity.class));
                finish();
            }
        });
    }
}