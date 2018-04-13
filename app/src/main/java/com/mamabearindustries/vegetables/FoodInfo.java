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


        EditText itemName = findViewById(R.id.enterItemName);
        EditText quantity = findViewById(R.id.enterQuantity);
        EditText date = findViewById(R.id.enterExpDate);

        Intent intent = new Intent(this, CurrentInventory.class);
        intent.putExtra("itemName", itemName.getText().toString());
        intent.putExtra("quantity", quantity.getText().toString());
        intent.putExtra("date", date.getText().toString());
        startActivity(intent);
    }




}


