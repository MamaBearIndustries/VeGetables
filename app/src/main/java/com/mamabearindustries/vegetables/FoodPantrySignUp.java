package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FoodPantrySignUp extends AppCompatActivity {
    static FoodPantry myFoodPantry;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pantry_sign_up);

        final EditText pantry_name = findViewById(R.id.enter_pantry_name);
        final EditText pantry_address = findViewById(R.id.enter_pantry_address);
        final EditText pantry_phoneNumber = findViewById(R.id.enter_pantry_phone_number);
        final EditText pantry_contactName = findViewById(R.id.enter_pantry_contact_name);
        final EditText pantry_contactEmail = findViewById(R.id.enter_pantry_contact_email);
        final  EditText pantry_username = findViewById(R.id.enter_pantry_username);
        final EditText pantry_password = findViewById(R.id.enter_pantry_password);

        Button FoodPantrySignUp = findViewById(R.id.Pantry_Sign_up);

        FoodPantrySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myFoodPantry = new FoodPantry(pantry_name.getText().toString(),pantry_address.getText().toString(),pantry_phoneNumber.getText().toString(),pantry_contactName.getText().toString(),pantry_contactEmail.getText().toString(),pantry_username.getText().toString(),pantry_password.getText().toString());
                final DatabaseReference pantries = database.getReference().child("Food Pantries").child(myFoodPantry.getPantryName()).child("Info");

                Map<String, Object> storeInfo = new HashMap<>();
                storeInfo.put("Address", myFoodPantry.getAddress());
                storeInfo.put("Phone Number", myFoodPantry.getPhoneNumber());
                storeInfo.put("Contact Name", myFoodPantry.getContactName());
                storeInfo.put("Contact Email", myFoodPantry.getContactEmail());
                storeInfo.put("Username", myFoodPantry.getUsername());
                storeInfo.put("Password", myFoodPantry.getPassword());

                pantries.updateChildren(storeInfo);

                Intent i = new Intent(
                        FoodPantrySignUp.this, Sign_In.class);
                startActivity(i);
            }
        });
    }
}
