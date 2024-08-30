package com.example.chatguru.SideNavPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chatguru.R;
import com.example.chatguru.SideNavPage.ProfileComponent.ProfileEditActivity;
import com.example.chatguru.SideNavigationActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    TextView editbtn;
    ImageView backbtn;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseFirestore mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backbtn = findViewById(R.id.backprofile);
        editbtn = findViewById(R.id.profileedit);


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mStore = FirebaseFirestore.getInstance();
        fatchData();


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, SideNavigationActivity.class));
                finish();
            }
        });


        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, ProfileEditActivity.class));
                finish();
            }
        });


    }


    public void fatchData(){
        String currentId = mUser.getUid();
        DocumentReference documentReference = mStore.collection("users").document(currentId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String name = documentSnapshot.getString("name");
                            TextView userName = (TextView) findViewById(R.id.profilename);
                            userName.setText(name);
                        }else {
                            Toast.makeText(ProfileActivity.this, "kuch problem hai", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProfileActivity.this, "mothed m error hai", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SideNavigationActivity.class));
        finish();
    }
}