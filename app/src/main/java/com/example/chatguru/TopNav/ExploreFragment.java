package com.example.chatguru.TopNav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.chatguru.R;
import com.example.chatguru.TopNav.ConnectInside.GroupCallActivity;

public class ExploreFragment extends Fragment {


    public ExploreFragment() {
        // Required empty public constructor
    }

    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        textView = view.findViewById(R.id.My_Video_group);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), GroupCallActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}