package com.example.onlinetreasurehunt2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Authentication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_main);
    }

    public void Register_onclick (View view){
        Intent i = new Intent(this,Register.class);
        startActivity(i);
    }

    public void Login_onclick (View view){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
