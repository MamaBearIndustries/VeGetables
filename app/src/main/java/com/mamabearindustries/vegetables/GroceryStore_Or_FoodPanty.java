package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GroceryStore_Or_FoodPanty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_store__or__food_panty);

        Button groceryStore = findViewById(R.id.store_Grocery);
        Button foodpantry = findViewById(R.id.pantry_Food);

        groceryStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        GroceryStore_Or_FoodPanty.this, GroceryStoreSignUp.class);
                startActivity(i);
            }
        });

        foodpantry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        GroceryStore_Or_FoodPanty.this, GroceryStoreSignUp.class);
                startActivity(i);
            }
        });

    }
}
