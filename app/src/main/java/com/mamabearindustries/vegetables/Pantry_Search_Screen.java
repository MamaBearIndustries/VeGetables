/**
 * Created by Vishnu Penubarthi
 */

package com.mamabearindustries.vegetables;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
private int counter = 0;
    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<String> checkboxNames = new ArrayList<>();
    DatabaseReference gStores = database.getReference("Message");
    static String pantryName = "Test Pantry Name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry__search__screen);
        final SearchView searchView = findViewById(R.id.searchView);
        //Getting the checkboxes and adding them to an arrayList of Checkboxes
        /**
         * This method is the primary method in which a user can query for a specific item, and get a list of stores which have that item.
         * They can then select a few of the items and then request for items from them.
         *
         */
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
                //Search for the values in database and populate Search Options
                FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/Message")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                       //Looks at exisiting values once and then detaches
                                       @Override
                                       public void onDataChange(DataSnapshot dataSnapshot) {
                                           //For each store under the main subclass...
                                           for (DataSnapshot stores : dataSnapshot.getChildren()) {
                                               //Loop through the items within each store
                                               for(DataSnapshot items : stores.getChildren())
                                               {
                                                   //If the stores contains the searched item
                                                   String itemName = items.getValue(String.class);
                                                   if (itemName.equals(str)) {
                                      //Get updated list of possible stores
                                        for (CheckBox checkBox : checkBoxes) {
                                            checkboxNames.add(checkBox.getText().toString());
                                        }
                                       //If the stores that contains this item is not on the list already, add it
                                        if (counter < 3) {
                                            if (!checkboxNames.contains(stores.getKey())) {
                                                checkBoxes.get(counter).setText(stores.getKey());
                                            }

                                        }
                                        //Counter is to ensure that we do not pass our 3 store max display
                                        counter++;
                                    }

                                   }
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

        item1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    gStores.child(item1.getText().toString()).child("Orders").child(pantryName).child("FoodItems").setValue(searchView.getQuery().toString());
                }
                if (!isChecked)
                {
                    Toast.makeText(Pantry_Search_Screen.this,"Hello",Toast.LENGTH_SHORT).show();

                }

            }
        });
        item2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    Toast.makeText(Pantry_Search_Screen.this,"Hello",Toast.LENGTH_SHORT).show();

                    // perform your action here
                }
                if (!isChecked)
                {
                    Toast.makeText(Pantry_Search_Screen.this,"Hello",Toast.LENGTH_SHORT).show();

                }

            }
        });
        item3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    Toast.makeText(Pantry_Search_Screen.this,"Hello",Toast.LENGTH_SHORT).show();

                    // perform your action here
                }
                if (!isChecked)
                {
                    Toast.makeText(Pantry_Search_Screen.this,"Hello",Toast.LENGTH_SHORT).show();

                }

            }
        });



    }

}