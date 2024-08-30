package com.example.chatguru;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.chatguru.TopNav.ViewPagerManagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager ViewPage;

    ImageView navimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tap);
        ViewPage = findViewById(R.id.ViewPage);
        navimg = findViewById(R.id.navImg);

        //////////////// tab layout code ///////////////////////////////////////////////////////////

          /////////////////// take image for tab layout //////////////////////////
        final int[] ICONS = new int[]{
                R.drawable.chat_plus_light,
                R.drawable.compas_mini_light,
                R.drawable.tab_bar};

           ///////////////   join Fragment page ////////////////////////////
        ViewPagerManagerAdapter adapter = new ViewPagerManagerAdapter(getSupportFragmentManager());
        ViewPage.setAdapter(adapter);

        tab.setupWithViewPager(ViewPage);

          //////////////////// set icon above line /////////////////////
        tab.getTabAt(0).setIcon(ICONS[0]);
        tab.getTabAt(1).setIcon(ICONS[1]);
        tab.getTabAt(2).setIcon(ICONS[2]);

        tab.getTabAt(0).getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), PorterDuff.Mode.SRC_IN);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Change the icon color of the selected tab
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Reset the icon color of unselected tab
                tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Do nothing here
            }
        });




        ////////////////////////////////////  set up nav page //////////////////////////////

        navimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SideNavigationActivity.class));
                finish();
            }
        });


    }


    public void onBackPressed() {
        if (ViewPage.getCurrentItem() > 0) {
            ViewPage.setCurrentItem(ViewPage.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }
}