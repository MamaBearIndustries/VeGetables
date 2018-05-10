package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button requestHere = findViewById(R.id.makeRequest_button);
        requestHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queEmail(Pantry_Search_Screen.availableStore.getContactEmail(),Pantry_Search_Screen.foodRequested.getNameItem(),String.valueOf(Pantry_Search_Screen.foodRequested.getQuantity()),Pantry_Search_Screen.availableStore.getContactName());

            }
        });


    }
    public void queEmail(String storeEmail, String foodrequested, String amountRequested, String contactName)
    {
        /*
        Yvsp- The below code was inspired by an answer to a stack overflow post https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
        The user who was the inspiration for the code below is Jeremy Logan
        Link to Profile: https://stackoverflow.com/users/76835/jeremy-logan
         */

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{storeEmail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Please donate to" + FoodPantrySignUp.myFoodPantry.getPantryName());
        i.putExtra(Intent.EXTRA_TEXT   , "Hello " + contactName + ", \n\n On behalf of " + FoodPantrySignUp.myFoodPantry.getPantryName() + ", I would like to ask you to donate to our food pantry. We are in need of " + foodrequested +" and through VeGetables, we saw that you have " + amountRequested + " available. Please contact us if you can donate. Our email is available above. \n\n Below is our information: \n\n Pantry Name: "
        + FoodPantrySignUp.myFoodPantry.getPantryName() + "\n Pantry Address:" + FoodPantrySignUp.myFoodPantry.getAddress() + "\n Food Pantry Phone Number: " + FoodPantrySignUp.myFoodPantry.getPhoneNumber() + " \n\n Thanks, \n"+ FoodPantrySignUp.myFoodPantry.getContactName()+"\n \n This email was sent through the VeGetables App");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
            Toast.makeText(RequestActivity.this,"Please go into your email app to send",Toast.LENGTH_SHORT).show();
          //  Intent intent = new Intent(RequestActivity.this, GroceryStore_Or_FoodPanty.class);
            //startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(RequestActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}
