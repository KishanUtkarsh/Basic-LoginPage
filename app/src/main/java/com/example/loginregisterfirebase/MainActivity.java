package com.example.loginregisterfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private Button loginbtn;
    private Button registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbtn = (Button) findViewById(R.id.loginbtn);
        registerbtn = (Button) findViewById(R.id.registerbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Login.class);
                startActivity(intent);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Register.class);
                startActivity(intent);
            }
        });

    }
}