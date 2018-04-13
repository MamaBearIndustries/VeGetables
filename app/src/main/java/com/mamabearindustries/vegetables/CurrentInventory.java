package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CurrentInventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_inventory);
    }

    public void addItem(View v)

    {
        Intent intent = new Intent(this, FoodInfo.class);
        startActivity(intent);
    }


    public void addToCurrentInventory(View v)
    {

        Bundle bundle = getIntent().getExtras();

        TextView item = findViewById(R.id.itemNameData);
        TextView quant = findViewById(R.id.quantityData);
        TextView expDate1 = findViewById(R.id.expDateData);

        String itemName = bundle.getString("itemName");
        String quantity = bundle.getString("quantity");
        String expDate = bundle.getString("date");


        item.setText(itemName);
        quant.setText(quantity);
        expDate1.setText(expDate);



    }



}

