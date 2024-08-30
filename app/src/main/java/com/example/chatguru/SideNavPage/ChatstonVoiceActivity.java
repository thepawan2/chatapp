package com.example.chatguru.SideNavPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatguru.R;
import com.example.chatguru.SideNavigationActivity;

public class ChatstonVoiceActivity extends AppCompatActivity {


    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatston_voice);

        backbtn = findViewById(R.id.backchatvoice);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatstonVoiceActivity.this, SideNavigationActivity.class));
                finish();
            }
        });


    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SideNavigationActivity.class));
        finish();
    }
}