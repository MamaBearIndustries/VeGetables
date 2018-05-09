package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);
       final EditText password = findViewById(R.id.enter_password_intro);
        final EditText username = findViewById(R.id.enter_user_name_intro);
        Button sign_up = findViewById(R.id.sign_up);
        Button sign_in = findViewById(R.id.sign_in);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Sign_In.this, GroceryStore_Or_FoodPanty.class);
                startActivity(i);
            }
        });
/*
Make it add to existing
 */
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FoodPantrySignUp.myFoodPantry!=null)
                {
                    FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/FoodPantries")
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    for(DataSnapshot pantries : dataSnapshot.getChildren())
                                    {
                                      if(pantries.child("Info").child("Username").getValue(String.class).equals(username.getText().toString())&&pantries.child("Info").child("Password").getValue(String.class).equals(password.getText().toString()))
                                        {
                                            Intent i = new Intent(
                                                    Sign_In.this, Pantry_Search_Screen.class);
                                            startActivity(i);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                }
                else if(GroceryStoreSignUp.myGroceryStore!=null)
                {
                    FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/GroceryStores")
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    for(DataSnapshot stores : dataSnapshot.getChildren())
                                    {
                                        if(stores.child("Info").child("Username").getValue(String.class).equals(username.getText().toString())&&stores.child("Info").child("Password").getValue(String.class).equals(password.getText().toString()))
                                        {
                                            //Toast.makeText(Sign_In.this,username.getText(),Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent(
                                                    Sign_In.this, CurrentInventory.class);
                                            startActivity(i);
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                }
                else
                {
                    Toast.makeText(Sign_In.this,"Please Sign Up for an Account",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
