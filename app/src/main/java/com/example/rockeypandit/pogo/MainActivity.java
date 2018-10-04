package com.example.rockeypandit.pogo;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.rockeypandit.pogo.CardsFolder.ArrayAdapters;
import com.example.rockeypandit.pogo.CardsFolder.Cards;
import com.example.rockeypandit.pogo.Matches.MatchesActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Cards cardsData[];
    private ArrayAdapters arrayAdapter;
    private int i;

    private FirebaseAuth mAuth;

    private String currentUId;
    private ImageView imgNoMore;
    private DatabaseReference usersDb;
    private Boolean interestedInSame = null , interestedInOpp = null;

    ListView listView;
    List<Cards> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usersDb = FirebaseDatabase.getInstance().getReference().child("User");

        mAuth = FirebaseAuth.getInstance();
        currentUId = mAuth.getCurrentUser().getUid();

        checkUserSex();
        imgNoMore = (ImageView)findViewById(R.id.imgNoMore);


        rowItems = new ArrayList<Cards>();

        arrayAdapter = new ArrayAdapters(this, R.layout.item,rowItems );

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
              //  Log.d("LIST", "removed object!");
                rowItems.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                Cards obj = (Cards) dataObject;
                String userId = obj.getUserId();
                usersDb.child(userId).child("connections").child("nope").child(currentUId).setValue(true);
                Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                Cards obj = (Cards) dataObject;
                String userId = obj.getUserId();
                usersDb.child(userId).child("connections").child("yeps").child(currentUId).setValue(true);
                isConnectionMatch(userId);
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
//                if (itemsInAdapter == 0)
//                    imgNoMore.setImageResource(R.drawable.pawlogo);

            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void isConnectionMatch(final String userId) {
        DatabaseReference currentUserConnectionsDb = usersDb.child(currentUId).child("connections").child("yeps").child(userId);
        currentUserConnectionsDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Toast.makeText(MainActivity.this,"new Connection",Toast.LENGTH_LONG).show();

                    String key = FirebaseDatabase.getInstance().getReference().child("Chat").push().getKey();

                    usersDb.child(dataSnapshot.getKey()).child("connections").child("matches").child(currentUId).child("ChatId").setValue(key);
                    usersDb.child(currentUId).child("connections").child("matches").child(dataSnapshot.getKey()).child("ChatId").setValue(key);


                    // usersDb.child(dataSnapshot.getKey()).child("connections").child("matches").child(currentUId).setValue(true);
                    //  usersDb.child(currentUId).child("connections").child("matches").child(dataSnapshot.getKey()).setValue(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private String userSex;
    private String oppositeUserSex;


    public void checkUserSex(){
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final DatabaseReference userDb =usersDb.child(user.getUid());
        userDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    if(dataSnapshot.child("sex").getValue() != null){

                        userSex = dataSnapshot.child("sex").getValue().toString();



                        if((dataSnapshot.child("interested in same").getValue().toString()).equalsIgnoreCase("true")){
                            interestedInSame =true;
                        }
                        if((dataSnapshot.child("interested in opp").getValue().toString()).equalsIgnoreCase("true")){
                            interestedInOpp =true;
                        }


                        if (interestedInSame && interestedInOpp ){
                            switch (userSex){
                                case "Male":
                                    oppositeUserSex = "Female";break;
                                case "Female":
                                    oppositeUserSex = "Male";
                                    break;
                            }
                            getOppositeSexUsers();

                            switch (userSex){
                                case "Male":
                                    oppositeUserSex = "Male";break;
                                case "Female":
                                    oppositeUserSex = "Female";
                                    break;
                            }
                            getOppositeSexUsers();

                        }
                        else if (interestedInSame){
                            switch (userSex){
                                case "Male":
                                    oppositeUserSex = "Male";break;
                                case "Female":
                                    oppositeUserSex = "Female";
                                    break;
                            }
                            getOppositeSexUsers();

                        }
                        else if (interestedInOpp){
                            switch (userSex) {
                                case "Male":
                                    oppositeUserSex = "Female";
                                    break;
                                case "Female":
                                    oppositeUserSex = "Male";
                                    break;
                            }
                            getOppositeSexUsers();

                        }

                    }



                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


    }

    List ids = new ArrayList();

    public void getOppositeSexUsers(){

        //DatabaseReference oppositeSexDb = FirebaseDatabase.getInstance().getReference().child("User").child(oppositeUserSex);
        usersDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.child("sex").getValue() != null) {
                    if (dataSnapshot.exists() && !dataSnapshot.child("connections").child("nope").hasChild(currentUId) && !dataSnapshot.child("connections").child("yeps").hasChild(currentUId) && dataSnapshot.child("sex").getValue().toString().equals(oppositeUserSex)) {


                        if (!(ids.contains(dataSnapshot.getKey()) )) {
                            if (!(dataSnapshot.getKey().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()))) {
                                ids.add(dataSnapshot.getKey());


                                //        if(usersDb.getKey())
                                Log.d("GET UID ", dataSnapshot.getKey());
                                    Log.d("GET KEY ", FirebaseAuth.getInstance().getCurrentUser().getUid());


                                String profileImageUrl = "default image";
                                if (dataSnapshot.child("profileImageUrl").getValue().equals("defaultimage")) {
                                    profileImageUrl = dataSnapshot.child("profileImageUrl").getValue().toString();
                                }
                                Cards item = new Cards(dataSnapshot.getKey(), dataSnapshot.child("name").getValue().toString(), profileImageUrl);
                                rowItems.add(item);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    public void logoutUser(View view) {
        mAuth.signOut();
        Intent intent = new Intent(MainActivity.this, ChooseLoginRegistrationActivity.class);
        startActivity(intent);
        finish();
        return;
    }


//    public void checkCurrentSex(){
//        String sex=null;
//        if(currentUId!=null){
//            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            sex= user.getUid();
//            Log.d("USER . GET UID",sex);
//        }
//        userSex=sex;
//
//    }





    public void goToSettings(View view) {
       // checkCurrentSex();
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        //System.out.print(userSex);
        startActivity(intent);

    }
    public void goToMatches(View view) {
       // checkCurrentSex();
        Intent intent = new Intent(MainActivity.this, MatchesActivity.class);
       // System.out.print(userSex);
        startActivity(intent);

    }
}