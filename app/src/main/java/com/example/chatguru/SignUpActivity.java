package com.example.chatguru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.hbb20.CountryCodePicker;

public class SignUpActivity extends AppCompatActivity {


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    AppCompatButton sendOtpBtn;
    ProgressBar progressBar;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        countryCodePicker = findViewById(R.id.login_countryCodepicker);
        phoneInput = findViewById(R.id.login_phone_number);
        sendOtpBtn = findViewById(R.id.login_otp_send_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneInput.setError("Phone number not valid");
                return;
            }
            Intent intent = new Intent(SignUpActivity.this, OtpActivity.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });

    }


}