package com.example.chatguru.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.chatguru.R;
import com.example.chatguru.SignUpActivity;

public class FourthSplashScreenActivity extends AppCompatActivity {

    AppCompatButton NextSplashBtn;

    TextView Skipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_splash_screen);


        NextSplashBtn = findViewById(R.id.splashbtn_3);
        Skipbtn = findViewById(R.id.skip3);

        NextSplashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FourthSplashScreenActivity.this, SignUpActivity.class));
                finish();
            }
        });

        Skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FourthSplashScreenActivity.this, SignUpActivity.class));
                finish();
            }
        });


    }
}