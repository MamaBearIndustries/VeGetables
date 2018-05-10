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

public class GroceryStoreSignUp extends AppCompatActivity {
 static GroceryStore myGroceryStore;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_store_sign_up);

       final EditText grocery_name = findViewById(R.id.enter_store_name);
        final EditText grocery_address = findViewById(R.id.enter_store_address);
        final EditText grocery_phoneNumber = findViewById(R.id.enter_store_phone_number);
        final EditText grocery_contactName = findViewById(R.id.enter_store_contact_name);
        final EditText grocery_contactEmail = findViewById(R.id.enter_store_contact_email);
        final  EditText grocery_username = findViewById(R.id.enter_username);
        final EditText grocery_password = findViewById(R.id.enter_grocery_password);

        Button storeSignup = findViewById(R.id.Sign_up);
        storeSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myGroceryStore = new GroceryStore(grocery_name.getText().toString(),grocery_address.getText().toString(),grocery_phoneNumber.getText().toString(),grocery_contactName.getText().toString(),grocery_contactEmail.getText().toString(),grocery_username.getText().toString(),grocery_password.getText().toString());
                final DatabaseReference stores = database.getReference().child("GroceryStores").child(myGroceryStore.getStoreName()).child("Info");


                Map<String, Object> store_grocery_info = new HashMap<>();
                store_grocery_info.put("Address", myGroceryStore.getAddress());
                store_grocery_info.put("PhoneNumber", myGroceryStore.getPhoneNumber());
                store_grocery_info.put("ContactName", myGroceryStore.getContactName());
                store_grocery_info.put("ContactEmail", myGroceryStore.getContactEmail());
                store_grocery_info.put("Username", myGroceryStore.getUsername());
                store_grocery_info.put("Password", myGroceryStore.getPassword());

                stores.updateChildren(store_grocery_info);

                Intent i = new Intent(
                        GroceryStoreSignUp.this, Sign_In.class);
                startActivity(i);
            }
        });

    }
}