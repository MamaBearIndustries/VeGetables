package com.mamabearindustries.vegetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcceptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);


    }

    public void previousRequest(View v)
    {
        TextView pastFoodPantry = findViewById(R.id.previousFoodPantry);
        TextView pastDate = findViewById(R.id.previousDate);
        TextView pastAddress = findViewById(R.id.previousAddress);
        TextView pastEmail = findViewById(R.id.pastEmail);
        TextView pastPhone = findViewById(R.id.previousPhoneNumber);
        TextView pastQuantity = findViewById(R.id.previousQuantity);
        TextView pastItem = findViewById(R.id.previousItem);
    }
}
