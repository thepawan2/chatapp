package com.example.chatguru.SideNavPage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatguru.R;
import com.example.chatguru.SideNavigationActivity;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SideNavigationActivity.class));
        finish();
    }
}