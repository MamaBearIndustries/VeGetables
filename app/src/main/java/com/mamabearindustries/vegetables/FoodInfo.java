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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);


        EditText itemNameText = findViewById(R.id.enterItemName);
        EditText quantityText = findViewById(R.id.enterQuantity);


        String itemName = itemNameText.getText().toString();
        int quantity = Integer.parseInt(quantityText.getText().toString());

        Food food = new Food(itemName, quantity);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("https://vegetables-1107.firebaseio.com/Message");
        DatabaseReference usersRef = ref.child("users");


        Intent intent = new Intent(this, CurrentInventory.class);
        intent.putExtra("itemName", itemName);
        intent.putExtra("quantity", quantity);
        startActivity(intent);





    }




}


