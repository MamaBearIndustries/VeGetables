/**
 * Created by Vishnu Penubarthi
 */

package com.mamabearindustries.vegetables;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
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
    private ArrayList<String> storeNames = new ArrayList<>();
    DatabaseReference gStores = database.getReference("Message");
    static String pantryName = "Test Pantry Name";
    static Request makeRequest;
    private View.OnClickListener getStoreInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry__search__screen);
        final SearchView searchView = findViewById(R.id.searchView);
        final LinearLayout list_of_stores = findViewById(R.id.list_of_stores);


        getStoreInfo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Pantry_Search_Screen.this, RequestActivity.class);
                startActivity(i);
            }
        };

        //Getting the checkboxes and adding them to an arrayList of Checkboxes
        /**
         * This method is the primary method in which a user can query for a specific item, and get a list of stores which have that item.
         * They can then select a few of the items and then request for items from them.
         *
         */


        //Have searchbox listen to what is being typed in
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String food) {
                //Search for the values in database and populate Search Options
                FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/GroceryStores")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                                       //Looks at exisiting values once and then detaches
                                       @Override
                                       public void onDataChange(DataSnapshot dataSnapshot) {
                                           //For each store under the main subclass...
                                           for (DataSnapshot stores : dataSnapshot.getChildren()) {
                                               //Loop through the items within each store
                                               for(DataSnapshot items : stores.child("Food").getChildren())
                                               {
                                              //     for(DataSnapshot itemName: subsec.getChildren())
                                                //   {
                                                 //  Toast.makeText(Pantry_Search_Screen.this,"Made it",Toast.LENGTH_SHORT).show();
                                                   //If the stores contains the searched item
                                                //   String itemName = items.getValue(String.class);
                                                  if (items.getKey().equals(food)) {
                                                    /*
                                                    YVSP-- This code below is to stop the app from looping through the database
                                                    twice when we only want it to do it once
                                                     */
                                                      if(!storeNames.contains(stores.getKey()))
                                                      {

                                                      storeNames.add(stores.getKey());

                                                          String val = String.valueOf(items.getValue(Integer.class));


                                                          addCards(list_of_stores,stores.getKey(),food,val);
                                                      /*
                                                          if(val!=null)

                                                          {


                                                              Toast.makeText(Pantry_Search_Screen.this,"Not Null",Toast.LENGTH_SHORT).show();
                                                              Toast.makeText(Pantry_Search_Screen.this,String.valueOf(val),Toast.LENGTH_SHORT).show();
                                                          }
                                                          else
                                                          {
                                                              Toast.makeText(Pantry_Search_Screen.this,"Null",Toast.LENGTH_SHORT).show();
                                                          }

                                                               */
                                                        //Toast.makeText(Pantry_Search_Screen.this,Integer.valueOf(items.getValue(Integer.class)),Toast.LENGTH_SHORT).show();


                                      //Get updated list of possible stores
                                      /*  for (CheckBox checkBox : checkBoxes) {
                                            checkboxNames.add(checkBox.getText().toString());
                                        }*/
                                       //If the stores that contains this item is not on the list already, add it
                                       // if (counter < 3) {
                                            //if (!checkboxNames.contains(stores.getKey())) {
                                              //  checkBoxes.get(counter).setText(stores.getKey());
                                          //  }

                                        //}
                                        //Counter is to ensure that we do not pass our 3 store max display
                                        counter++;
                                                      }
                                  }
                                                   //}

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


    }
   static GroceryStore availableStore;
    static Food foodRequested;
    public void addCards(LinearLayout list_of_stores, final String name_of_store, final String name_of_food, final String amountOfFood) {

    /*    Button testy = new Button(this);
        testy.setBackgroundColor(Color.WHITE);
        testy.setElevation(10);

        testy.setPadding(0,2,0,2);
        testy.setMinimumHeight(30);
        testy.setText(name_of_store);
        testy.setTextColor(Color.BLACK);
        testy.setTextSize(25);

        testy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

      CardView itemsinfo = new CardView(this);
        itemsinfo.setCardBackgroundColor(Color.WHITE);
        itemsinfo.setCardElevation(10);
        itemsinfo.setRadius(3);
        itemsinfo.setPadding(0,2,0,2);
        itemsinfo.setMinimumHeight(30);

    TextView singleCard = new TextView(this);
        singleCard.setText(name_of_store);
        singleCard.setTextColor(Color.BLACK);
        singleCard.setTextSize(25);


       itemsinfo.addView(singleCard);


        itemsinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(Pantry_Search_Screen.this,"Clicked",Toast.LENGTH_SHORT).show();

                FirebaseDatabase.getInstance().getReferenceFromUrl("https://vegetables-1107.firebaseio.com/GroceryStores").
                        addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for(DataSnapshot individualStore : dataSnapshot.getChildren())
                                {
                                    if(individualStore.getKey().equals(name_of_store))
                                    {
                                       // Toast.makeText(Pantry_Search_Screen.this,"Made it",Toast.LENGTH_SHORT).show();

                                        availableStore = new GroceryStore(name_of_store,individualStore.child("Info").child("Address").getValue(String.class),individualStore.child("Info").child("Phone Number").getValue(String.class),individualStore.child("Info").child("Contact Name").getValue(String.class),individualStore.child("Info").child("Contact Email").getValue(String.class),individualStore.child("Info").child("Username").getValue(String.class),individualStore.child("Info").child("Password").getValue(String.class));
                                        foodRequested = new Food(name_of_food,Integer.valueOf(amountOfFood));
                                        //Toast.makeText(Pantry_Search_Screen.this,String.valueOf(foodRequested.getQuantity()),Toast.LENGTH_SHORT).show();

                                        Intent i = new Intent( Pantry_Search_Screen.this, RequestActivity.class);

                                           startActivity(i);
                                    }
                                }
                            //    availableStore = new GroceryStore(name_of_store,dataSnapshot.child("Info").child("Address").getValue(String.class),dataSnapshot.child("Info").child("Phone Number").getValue(String.class),dataSnapshot.child("Info").child("Contact Name").getValue(String.class),dataSnapshot.child("Info").child("Contact Email").getValue(String.class),dataSnapshot.child("Info").child("Username").getValue(String.class),dataSnapshot.child("Info").child("Password").getValue(String.class));
                             // Toast.makeText(Pantry_Search_Screen.this,availableStore.getStoreName(),Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

             //   Toast.makeText(Pantry_Search_Screen.this,makeRequest.getGroceryStore().getContactEmail(),Toast.LENGTH_SHORT).show();

                   // Toast.makeText(Pantry_Search_Screen.this,"fds",Toast.LENGTH_SHORT).show();

           //   Intent i = new Intent( Pantry_Search_Screen.this, RequestActivity.class);
             //   startActivity(i);

            }
        });


        list_of_stores.addView(itemsinfo);



    }

}