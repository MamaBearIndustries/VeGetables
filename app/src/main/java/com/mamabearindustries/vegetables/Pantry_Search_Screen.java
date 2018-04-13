package com.mamabearindustries.vegetables;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pantry_Search_Screen extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReferenceFromUrl("https://vegetables-1107.firebaseio.com/message");
    String word = "";
    int counter = 0;
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry__search__screen);
        SearchView searchView = findViewById(R.id.searchView);

        final CheckBox item1 = findViewById(R.id.item_2);
        final CheckBox item2 = findViewById(R.id.item_3);
        final CheckBox item3 = findViewById(R.id.item_1);
        checkBoxes.add(item1);
        checkBoxes.add(item2);
        checkBoxes.add(item3);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String str) {
                // Toast.makeText(Pantry_Search_Screen.this,s,Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference().child("message")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    String user = snapshot.getValue(String.class);
                                        String val = "item" + Integer.toString(counter);

                                                checkBoxes.get(counter).setText(user);



                                    counter++;
                                    if(counter>2)
                                        break;

                                }
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });



                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });




    }

}