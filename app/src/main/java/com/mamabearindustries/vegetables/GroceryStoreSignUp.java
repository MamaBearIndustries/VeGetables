package com.mamabearindustries.vegetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
       myGroceryStore = new GroceryStore("test","test","test","test","test","test","test");
      final DatabaseReference stores = database.getReference().child("Grocery Stores").child(myGroceryStore.getStoreName()).child("Info");

        Button storeSignup = findViewById(R.id.SignUp);
        storeSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
