package com.mamabearindustries.vegetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FoodInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);
    }
     public void createNewItem(View V)
    {

        EditText itemName = findViewById(R.id.enterItemName);
        EditText quantity = findViewById(R.id.enterQuantity);
        EditText date = findViewById(R.id.enterExpDate);

        Button addItem = findViewById(R.id.addItemButton);






    }




}


