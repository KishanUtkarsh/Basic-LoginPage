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
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    private EditText emailedittext;
    private EditText passwordedittext;
    private Button loginbtn;
    private FirebaseAuth firebaseAuth;

    private String Email , Password;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailedittext = (EditText) findViewById(R.id.emaileditText);
        passwordedittext = (EditText) findViewById(R.id.passwordeditText);
        loginbtn = (Button) findViewById(R.id.loginbtnloginpage);
        firebaseAuth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Login", Toast.LENGTH_SHORT).show();
                Email = emailedittext.getText().toString();
                Password = passwordedittext.getText().toString();

                if(TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)){
                    Toast.makeText(Login.this, "Error in Fillings", Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseLogin(Email,Password);

                }


            }
        });


    }
    private void FirebaseLogin(String email , String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}