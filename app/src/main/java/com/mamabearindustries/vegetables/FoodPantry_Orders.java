package com.mamabearindustries.vegetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FoodPantry_Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pantry__orders);
    }

    public void FoodPantry_Orders(View v)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello World!");
        /*
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("numbers").push().setValue("hello");
        */

        /*
        TextView PendingRequestText = findViewById(R.id.lblPendingRequests);
        TextView ConfirmedRequestText = findViewById(R.id.lblConfirmedRequests);

        Bundle bundle = getIntent().getExtras();

        Double PendingRequest = bundle.getDouble("");
        Double ConfirmedRequest = bundle.getDouble("");
        */




    }


}
