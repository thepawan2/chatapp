package com.example.chatguru.TopNav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.chatguru.R;
import com.example.chatguru.TopNav.ExploreInside.GroupActivity;


public class ConnectFragment extends Fragment {



    public ConnectFragment() {
        // Required empty public constructor
    }

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_connect, container, false);

        textView = view.findViewById(R.id.My_Make_group);

        textView.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), GroupActivity.class);
            startActivity(intent);
        });

        return view;
    }
}