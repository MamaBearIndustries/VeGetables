package com.mamabearindustries.vegetables;

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
 GroceryStore myGroceryStore;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_store_sign_up);
       final EditText name = findViewById(R.id.enter_store_name);
        final EditText address = findViewById(R.id.enter_store_address);
        final EditText phoneNumber = findViewById(R.id.enter_store_phone_number);
        final EditText contactName = findViewById(R.id.enter_store_contact_name);
        final EditText contactEmail = findViewById(R.id.enter_store_contact_email);
        final  EditText username = findViewById(R.id.enter_username);
        final EditText password = findViewById(R.id.enter_password);

        Button storeSignup = findViewById(R.id.Sign_up);
        storeSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myGroceryStore = new GroceryStore(name.getText().toString(),address.getText().toString(),phoneNumber.getText().toString(),contactName.getText().toString(),contactEmail.getText().toString(),username.getText().toString(),password.getText().toString());
                final DatabaseReference stores = database.getReference().child("Grocery Stores").child(myGroceryStore.getStoreName()).child("Info");


                Map<String, Object> storeInfo = new HashMap<>();
                storeInfo.put("Address", myGroceryStore.getAddress());
                storeInfo.put("Phone Number", myGroceryStore.getPhoneNumber());
                storeInfo.put("Contact Name", myGroceryStore.getContactName());
                storeInfo.put("Contact Email", myGroceryStore.getContactEmail());
                storeInfo.put("Username", myGroceryStore.getUsername());
                storeInfo.put("Password", myGroceryStore.getPassword());

                stores.updateChildren(storeInfo);
            }
        });

    }
}