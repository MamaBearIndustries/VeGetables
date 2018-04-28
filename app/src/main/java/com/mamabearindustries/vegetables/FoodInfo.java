package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FoodInfo extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);


       final EditText itemNameText = findViewById(R.id.enterItemName);
      final  EditText quantityText = findViewById(R.id.enterQuantity);
      final  Button additem = findViewById(R.id.addItemButton);

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = itemNameText.getText().toString();
                int quantity = Integer.parseInt(quantityText.getText().toString());
                Food food = new Food(itemName, quantity);

                DatabaseReference foods = database.getReferenceFromUrl("https://vegetables-1107.firebaseio.com/GroceryStores")
                        .child(GroceryStoreSignUp.myGroceryStore.getStoreName()).child("Food");

                //Still have not implemented way to check if an item already exists and then add/update the number of that item
                //This only adds items so far as if they never existed

                Map<String, Object> store_food_info = new HashMap<>();
                store_food_info.put(food.getNameItem(),food.getQuantity());
                foods.updateChildren(store_food_info);

                Intent intent = new Intent(FoodInfo.this, CurrentInventory.class);
                startActivity(intent);

            }
        });








    }




}


