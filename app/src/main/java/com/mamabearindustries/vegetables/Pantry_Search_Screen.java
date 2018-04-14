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
    //All the relevant references
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReferenceFromUrl("https://vegetables-1107.firebaseio.com/message");
    String word = "";
    int counter = 0;
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    ArrayList<String> checkboxNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry__search__screen);
        SearchView searchView = findViewById(R.id.searchView);
        //Getting the checkboxes and adding them to an arrayList of Checkboxes
        final CheckBox item1 = findViewById(R.id.item_2);
        final CheckBox item2 = findViewById(R.id.item_3);
        final CheckBox item3 = findViewById(R.id.item_1);
        checkBoxes.add(item1);
        checkBoxes.add(item2);
        checkBoxes.add(item3);
        //Have searchbox listen to what is being typed in
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String str) {
                // Toast.makeText(Pantry_Search_Screen.this,s,Toast.LENGTH_SHORT).show();
                //Search for the values in database and populate Search Options
                FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/Message")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    String user = snapshot.getValue(String.class);
                                    for(CheckBox checkBox: checkBoxes)
                                    {
                                        checkboxNames.add(checkBox.getText().toString());
                                    }
                                    if(counter<3)
                                    {
                                        if(!checkboxNames.contains(user))
                                        {
                                            checkBoxes.get(counter).setText(user);
                                        }

                                   }




                                 /*   if(counter>1)
                                         break;*/

                                    counter++;
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