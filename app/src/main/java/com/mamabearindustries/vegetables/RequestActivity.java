package com.mamabearindustries.vegetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class RequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        TextView putContactName = findViewById(R.id.request_name_text);
        putContactName.setText(Pantry_Search_Screen.availableStore.getContactName());
        TextView putAddress = findViewById(R.id.request_address_text);
        putAddress.setText(Pantry_Search_Screen.availableStore.getAddress());
        TextView putEmail = findViewById(R.id.request_contact_email_text);
        putEmail.setText(Pantry_Search_Screen.availableStore.getContactEmail());
        TextView putNumber = findViewById(R.id.request_contact_number_text);
        putNumber.setText(Pantry_Search_Screen.availableStore.getPhoneNumber());
      TextView putFoodName = findViewById(R.id.request_food_name_text);
        putFoodName.setText(Pantry_Search_Screen.foodRequested.getNameItem());
        TextView putFoodQuantity = findViewById(R.id.request_food_number_text);
        putFoodQuantity.setText(String.valueOf(Pantry_Search_Screen.foodRequested.getQuantity()));



    }
}
