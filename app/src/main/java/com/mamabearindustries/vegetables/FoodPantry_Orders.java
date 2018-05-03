package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FoodPantry_Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_pantry__orders);

        final LinearLayout list_of_items = findViewById(R.id.list_of_items);

        FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/FoodPantries").child(FoodPantrySignUp.myFoodPantry.getPantryName()).child("Food")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                            public void onDataChange(DataSnapshot dataSnapshot){
                            for(DataSnapshot fooditems: dataSnapshot.getChildren())
                            {
                            String itemName = fooditems.getKey();
                            String itemQuantity = String.valueOf(fooditems.getValue(Integer.class));
                            addlayout(list_of_items,itemName,itemQuantity);
                            }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

         /*
        TextView PendingRequestText = findViewById(R.id.lblPendingRequests);
        TextView ConfirmedRequestText = findViewById(R.id.lblConfirmedRequests);

        String PendingRequest = PendingRequestText.getText().toString();
        String ConfirmedRequest = ConfirmedRequestText.getText().toString();

        Food food = new Food("Honey",5);
        GroceryStore groceryStore = new GroceryStore("MamaBears", "85 Honey Street","514-123-4356","MamaBear","MamaBear@gmail.com","MamaBear","ThisIsABadPassword");
        FoodPantry foodPantry = new FoodPantry("PapaBear","86 Honey Street","514-234-6452","PapaBear","PapaBear@gmail.com","PapaBear","EvenWorsePassword");

        Request request = new Request(food,groceryStore,foodPantry);

        PendingRequestText.setText("Item: "+request.getFood().getNameItem().toString());
        */
    }

    public void addlayout(LinearLayout list_of_items, String itemName, String itemQuantity)
    {
        LinearLayout itemsinfo = new LinearLayout(this);
        itemsinfo.setOrientation(LinearLayout.HORIZONTAL);

        TextView itemname = new TextView(this);
        itemname.setText("Item Name:");
        itemname.setMinWidth(100);
        itemname.setTextSize(25);
        //itemname.setTypeface(cinzel);
        itemname.setPadding(20,0,20,0);
        itemsinfo.addView(itemname);

        TextView name_of_item = new TextView(this);
        name_of_item.setText(itemName);
        name_of_item.setMinWidth(100);
        name_of_item.setTextSize(25);
        //name_of_item.setTypeface(cinzel);
        name_of_item.setPadding(0,0,20,0);
        itemsinfo.addView(name_of_item);

        TextView itemquantity = new TextView(this);
        itemquantity.setText("Item Quantity:");
        itemquantity.setMinWidth(100);
        itemquantity.setTextSize(25);
        //itemquantity.setTypeface(cinzel);
        itemquantity.setPadding(0,0,20,0);
        itemsinfo.addView(itemquantity);

        TextView quantity_of_item = new TextView(this);
        quantity_of_item.setText(itemQuantity);
        quantity_of_item.setMinWidth(100);
        //quantity_of_item.setTypeface(cinzel);
        quantity_of_item.setTextSize(25);
        itemsinfo.addView(quantity_of_item);

        itemsinfo.setPadding(0,20,0,20);

        list_of_items.addView(itemsinfo);

    }


}
/*
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //addItems(list_of_items);
                Intent i = new Intent(CurrentInventory.this, FoodInfo.class);
                startActivity(i);
            }
        });
    }

    public void addItems(LinearLayout list_of_items)

    {
        for( int i = 0; i < 10; i++ )
        {
            TextView textView = new TextView(this);
            textView.setId(i);
            textView.setText("hello");
            list_of_items.addView(textView);
        }

    }


    public void addToCurrentInventory(View v)
    {

        Bundle bundle = getIntent().getExtras();
    }

}
*/


