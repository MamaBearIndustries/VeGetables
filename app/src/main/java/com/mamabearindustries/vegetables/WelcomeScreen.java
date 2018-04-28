package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    Button toMainAct = findViewById(R.id.toMainAct);
    Button toSignIn = findViewById(R.id.sign_in);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.toMainAct)
        {

        }
        if(v.getId()==R.id.toSignIn)
        {

        }
    }
}
