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

        TextView PendingRequestText = findViewById(R.id.lblPendingRequests);
        TextView ConfirmedRequestText = findViewById(R.id.lblConfirmedRequests);

        String PendingRequest = PendingRequestText.getText().toString();
        String ConfirmedRequest = ConfirmedRequestText.getText().toString();

        Food food = new Food("Honey",5);
        GroceryStore groceryStore = new GroceryStore("MamaBears", "85 Honey Street","514-123-4356","MamaBear","MamaBear@gmail.com","MamaBear","ThisIsABadPassword");
        FoodPantry foodPantry = new FoodPantry("PapaBear","86 Honee Street","514-234-6452","PapaBear","PapaBear@gmail.com","PapaBear","EvenWorsePassword");

        Request request = new Request(food,groceryStore,foodPantry);

        PendingRequestText.setText("Item: "+request.getFood().getNameItem().toString());

    }

}
