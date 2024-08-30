package com.example.chatguru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.chatguru.SideNavPage.ChatstonVoiceActivity;
import com.example.chatguru.SideNavPage.HelpFeedbackActivity;
import com.example.chatguru.SideNavPage.ProfileActivity;
import com.example.chatguru.SideNavPage.SecurityActivity;
import com.example.chatguru.SideNavPage.SettingActivity;
import com.example.chatguru.SideNavPage.ShareProfileActivity;
import com.example.chatguru.SideNavPage.SwitchActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class SideNavigationActivity extends AppCompatActivity {


    ImageView imgbtn, imageView;

    TextView SwitchAaccount, SecurityPrivacy, Setting, ChatstonVoice,ShareProfile, HelpFeedback;

    AppCompatButton logout;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseFirestore mStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_navigation);

        /////////// cross btn ///////////////////////////////////
        imgbtn = findViewById(R.id.backbtnimg);

        ////////////////////// image icon ////////////////////////
        imageView = findViewById(R.id.imageView1);

        ////////////////////// nav item ///////////////////////////
        SwitchAaccount = findViewById(R.id.switch_account);
        SecurityPrivacy = findViewById(R.id.security_privacy);
        Setting = findViewById(R.id.setting);
        ChatstonVoice = findViewById(R.id.chatston_voice);
        ShareProfile = findViewById(R.id.share_profile);
        HelpFeedback = findViewById(R.id.help_feedback);

        /////////////////////// Logout /////////////////////////////////
        logout = findViewById(R.id.Logout);


         //////////////////////////////// fatchdata /////////////////////////
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mStore = FirebaseFirestore.getInstance();
        fatchData();

        //////////////////// cross btn working /////////////////////////////
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, MainActivity.class));
                finish();
            }
        });

        ////////////////////////image icon working////////////////////////////

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, ProfileActivity.class));
                finish();
            }
        });

        ////////////////////// Switch Account ////////////////////////////////

        SwitchAaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, SwitchActivity.class));
                finish();
            }
        });

        ///////////////////////////// Security Privacy /////////////////////////

        SecurityPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, SecurityActivity.class));
                finish();
            }
        });

        ///////////////////////////// Setting /////////////////////////////////

        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, SettingActivity.class));
                finish();
            }
        });

        ///////////////////////////// Chatston Voice //////////////////////////

        ChatstonVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, ChatstonVoiceActivity.class));
                finish();
            }
        });

        ///////////////////////////// Share Profile ////////////////////////////

      ShareProfile.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(SideNavigationActivity.this, ShareProfileActivity.class));
              finish();
          }
      });

        ///////////////////////////// Help and feedback ////////////////////////////

        HelpFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SideNavigationActivity.this, HelpFeedbackActivity.class));
                finish();
            }
        });


        ///////////////////////////  logout btn /////////////////////////////////
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SideNavigationActivity.this, SignUpActivity.class));
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
                            String name = documentSnapshot.getString("username");
                            String email = documentSnapshot.getString("emailid");
                            TextView userName = (TextView) findViewById(R.id.sidenavname);
                            TextView userEmail = (TextView) findViewById(R.id.sidenavemail);
                            userName.setText(name);
                            userEmail.setText(email);
                        }else {
                            Toast.makeText(SideNavigationActivity.this, "kuch problem hai", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SideNavigationActivity.this, "mothed m error hai", Toast.LENGTH_SHORT).show();
                    }
           });
    }



    @Override
    public void onBackPressed() {
        startActivity(new Intent(SideNavigationActivity.this, MainActivity.class));
        finish();
    }
}