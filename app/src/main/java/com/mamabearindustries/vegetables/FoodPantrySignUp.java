package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.provider.Settings;
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
    String m_androidId;
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
                final DatabaseReference pantries = database.getReference().child("FoodPantries").child(myFoodPantry.getPantryName()).child("Info");

                Map<String, Object> pantryInfo = new HashMap<>();
                pantryInfo.put("Address", myFoodPantry.getAddress());
                pantryInfo.put("PhoneNumber", myFoodPantry.getPhoneNumber());
                pantryInfo.put("ContactName", myFoodPantry.getContactName());
                pantryInfo.put("ContactEmail", myFoodPantry.getContactEmail());
                pantryInfo.put("Username", myFoodPantry.getUsername());
                pantryInfo.put("Password", myFoodPantry.getPassword());

                pantries.updateChildren(pantryInfo);

                final DatabaseReference specificPantry = database.getReference().child("PantryIds").child(getId()).child("Info");

                Map<String, Object> pantryIDInfo = new HashMap<>();
                pantryIDInfo.put("Address", myFoodPantry.getAddress());
                pantryIDInfo.put("PhoneNumber", myFoodPantry.getPhoneNumber());
                pantryIDInfo.put("ContactName", myFoodPantry.getContactName());
                pantryIDInfo.put("ContactEmail", myFoodPantry.getContactEmail());
                pantryIDInfo.put("Username", myFoodPantry.getUsername());
                pantryIDInfo.put("Password", myFoodPantry.getPassword());
                pantryIDInfo.put("Name",myFoodPantry.getPantryName());




                specificPantry.updateChildren(pantryIDInfo);


                Intent i = new Intent(
                        FoodPantrySignUp.this, Sign_In.class);
                startActivity(i);
            }
        });
    }
    public String getId()
    {
        try {

            m_androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return m_androidId;
    }
}
