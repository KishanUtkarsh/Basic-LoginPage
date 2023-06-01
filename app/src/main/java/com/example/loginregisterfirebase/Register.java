package com.example.loginregisterfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText nameedittext , emailedittext , passwordedittext , mobileedittext;
    private Button registerbtn;
    private FirebaseAuth firebaseAuth;

    private String Name , Email , Password , MobileNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameedittext = (EditText) findViewById(R.id.nameedittext);
        emailedittext = (EditText) findViewById(R.id.emailregpage);
        passwordedittext = (EditText) findViewById(R.id.passwordregpage);
        mobileedittext = (EditText) findViewById(R.id.mobNumber);
        registerbtn = (Button) findViewById(R.id.reisterbtnregpage);
        firebaseAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this, "Registered", Toast.LENGTH_SHORT).show();

                Name = nameedittext.getText().toString();
                Email = emailedittext.getText().toString();
                Password = passwordedittext.getText().toString();
                MobileNumber = mobileedittext.getText().toString();

                if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(Email)|| TextUtils.isEmpty(Password)|| TextUtils.isEmpty(MobileNumber)){
                    Toast.makeText(Register.this, "Error in Filling", Toast.LENGTH_SHORT).show();
                }else{
                    RegisterFirebase(Email,Password);
                }

            }
        });
    }
    private void RegisterFirebase(String email , String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Register.this, "Failed   ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}