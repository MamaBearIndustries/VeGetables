package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CurrentInventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_inventory);
    }

    public void addItem(View v)

    {
        Intent intent = new Intent(this, FoodInfo.class);
    }


    public void addToCurrentInventory(View v)
    {

    }



}

