package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

public class CurrentInventory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_inventory);
        final LinearLayout list_of_items = findViewById(R.id.list_of_items);
        Button addItemScreen = findViewById(R.id.addItemScreen);

       // final Typeface cinzel = Typeface.createFromAsset(getAssets(),"fonts/cinzel.ttf");

        FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/GroceryStores").child(GroceryStoreSignUp.myGroceryStore.getStoreName()).child("Food")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot fooditems : dataSnapshot.getChildren())
                        {
                            //Toast.makeText(CurrentInventory.this,fooditems.getKey(),Toast.LENGTH_SHORT).show();

                           String itemName = fooditems.getKey();
                           String itemQuantity = String.valueOf(fooditems.getValue(Integer.class));

                           // Toast.makeText(CurrentInventory.this,itemName+"  "+itemQuantity,Toast.LENGTH_SHORT).show();
                           addlayout(list_of_items,itemName,itemQuantity);

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


        addItemScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //   Toast.makeText(CurrentInventory.this,"HE",Toast.LENGTH_SHORT).show();
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
    public void addlayout(LinearLayout list_of_items, String itemName, String itemQuantity)
    {
        LinearLayout itemsinfo = new LinearLayout(this);
        itemsinfo.setOrientation(LinearLayout.HORIZONTAL);

        TextView itemname = new TextView(this);
        itemname.setText("Item Name:");
        itemname.setMinWidth(100);
        itemname.setTextSize(24);
        itemname.setPadding(30,0,10,0);
        itemsinfo.addView(itemname);

        TextView name_of_item = new TextView(this);
        name_of_item.setText(itemName);
        name_of_item.setMinWidth(100);
        name_of_item.setTextSize(24);
        //name_of_item.setTypeface(cinzel);
        name_of_item.setPadding(0,0,20,0);
        itemsinfo.addView(name_of_item);

        TextView itemquantity = new TextView(this);
        itemquantity.setText("Item Quantity:");
        itemquantity.setMinWidth(100);
        itemquantity.setTextSize(24);
        //itemquantity.setTypeface(cinzel);
        itemquantity.setPadding(150,0,0,0);
        itemsinfo.addView(itemquantity);

        TextView quantity_of_item = new TextView(this);
        quantity_of_item.setText(itemQuantity);
        quantity_of_item.setMinWidth(100);
        //quantity_of_item.setTypeface(cinzel);
        quantity_of_item.setTextSize(24);
        itemsinfo.addView(quantity_of_item);
        quantity_of_item.setPadding(0,0,20,0);

        itemsinfo.setPadding(0,0,20,0);

        list_of_items.addView(itemsinfo);

    }
}

