package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_search);
    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.button_search)
        {
            Intent i = new Intent(
                    MainActivity.this,
                    Pantry_Search_Screen.class);
            startActivity(i);
        }
    }
}
