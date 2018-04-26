package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FoodInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);


        EditText itemNameText = findViewById(R.id.enterItemName);
        EditText quantityText = findViewById(R.id.enterQuantity);
        EditText dateText = findViewById(R.id.enterExpDate);

        String itemName = itemNameText.getText().toString();
        int quantity = Integer.parseInt(quantityText.getText().toString());
        String date = dateText.getText().toString();

        Food food = new Food(itemName, quantity);


        Intent intent = new Intent(this, CurrentInventory.class);
        intent.putExtra("itemName", itemName);
        intent.putExtra("quantity", quantity);
        intent.putExtra("date", date);
        startActivity(intent);
    }




}


