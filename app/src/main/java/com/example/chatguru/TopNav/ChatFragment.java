package com.example.chatguru.TopNav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatguru.R;
import com.example.chatguru.SearchUserActivity;
import com.example.chatguru.adapter.RecentChatRecyclerAdapter;
import com.example.chatguru.model.ChatroomModel;
import com.example.chatguru.utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;


public class ChatFragment extends Fragment {



    public ChatFragment() {
        // Required empty public constructor
    }

     ImageButton searchBtn;

    RecyclerView recyclerView;

    RecentChatRecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        setupRecyclerView();

        searchBtn = view.findViewById(R.id.image_button);

        searchBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), SearchUserActivity.class);
            startActivity(intent);
        });


        return view;
    }


    void setupRecyclerView(){
        Query query = FirebaseUtil.allChatroomCollectionReference()
                .whereArrayContains("userIds",FirebaseUtil.currentUserId())
                .orderBy("lastMessageTimestamp",Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<ChatroomModel> options = new FirestoreRecyclerOptions.Builder<ChatroomModel>()
                .setQuery(query, ChatroomModel.class).build();

        adapter = new RecentChatRecyclerAdapter(options,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null)
            adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null)
            adapter.notifyDataSetChanged();
    }
}