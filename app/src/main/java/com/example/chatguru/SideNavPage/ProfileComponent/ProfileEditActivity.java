package com.example.chatguru.SideNavPage.ProfileComponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatguru.R;
import com.example.chatguru.SideNavPage.ProfileActivity;

public class ProfileEditActivity extends AppCompatActivity {

    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        backbtn = findViewById(R.id.backprofile1);


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileEditActivity.this, ProfileActivity.class));
                finish();
            }
        });



    }



    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ProfileActivity.class));
        finish();
    }
}