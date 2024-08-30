package com.example.chatguru.TopNav;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerManagerAdapter extends FragmentPagerAdapter {


    public ViewPagerManagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position==0){
              return new ChatFragment();
        } else if (position==1) {
            return new ExploreFragment();
        } else {
            return new ConnectFragment();
        }
    }

    @Override
    public int getCount() {
        return 3; //no of tabs in top
    }




}
