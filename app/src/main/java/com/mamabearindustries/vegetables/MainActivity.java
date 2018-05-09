package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The bottom navigation starts here
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.action_add:
                        Toast.makeText(MainActivity.this, "Action Add Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_edit:
                        Toast.makeText(MainActivity.this, "Action Edit Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_remove:
                        Toast.makeText(MainActivity.this, "Action Remove Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        //myRef.setValue("Hello, World!");
        Button button = (Button) findViewById(R.id.button_search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        MainActivity.this,
                        Pantry_Search_Screen.class);
                startActivity(i);
            }
        });


        Button CurrentInv = (Button) findViewById(R.id.button2);
        CurrentInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        MainActivity.this, CurrentInventory.class);
                startActivity(i);
            }
        });

        Button signIn = (Button) findViewById(R.id.toSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        MainActivity.this, Sign_In.class);
                startActivity(i);
            }
        });


        Button FoodPantryOrder = (Button) findViewById(R.id.FoodPantryOrder);
        FoodPantryOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        MainActivity.this, FoodPantry_Orders.class);
                startActivity(i);
            }
        });
    }

}