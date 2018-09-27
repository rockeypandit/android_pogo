package com.example.rockeypandit.pogo;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.akhgupta.easylocation.EasyLocationAppCompatActivity;
import com.akhgupta.easylocation.EasyLocationRequest;
import com.akhgupta.easylocation.EasyLocationRequestBuilder;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RegistrationActivity extends EasyLocationAppCompatActivity {

    private Button mRegister;
    private EditText mEmail, mPassword, mName;
    private RadioGroup mRadioGroup;
    private TextView locationTextBox;
    private CheckBox mCheckSameSex,mCheckOppSex;

    private Double myLatitude,myLongitude;


    Boolean interestedInSame=false,interestedInOpp=false;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Animation expandIn = AnimationUtils.loadAnimation(this, R.anim.popin);

        mAuth = FirebaseAuth.getInstance();





        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user !=null){
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };


        mRegister = (Button) findViewById(R.id.register);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mName = (EditText) findViewById(R.id.name);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mName = (EditText) findViewById(R.id.name);
        locationTextBox = (TextView) findViewById(R.id.locationText);
        mCheckSameSex = (CheckBox) findViewById(R.id.checkSameSex);
        mCheckOppSex = (CheckBox) findViewById(R.id.checkOppSex);


        mEmail.startAnimation(expandIn);
        mRegister.startAnimation(expandIn);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int selectId = mRadioGroup.getCheckedRadioButtonId();
                final RadioButton radioButton = (RadioButton) findViewById(selectId);

                if(radioButton.getText() == null){
                    return;
                }


                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                final String name = mName.getText().toString();
                locationRequest();
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            String userId = mAuth.getCurrentUser().getUid();
                            DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("User").child(userId);
                            Map userInfo = new HashMap<>();
                            userInfo.put("name",name);
                            userInfo.put("sex",radioButton.getText().toString());
                            userInfo.put("profileImageUrl","defaultimage");

                            if(mCheckSameSex.isChecked()){
                                interestedInSame=true;
                            }
                            if(mCheckOppSex.isChecked()){
                                interestedInOpp=true;
                            }
                            userInfo.put("interested in same",interestedInSame);
                            userInfo.put("interested in opp",interestedInOpp);

                            userInfo.put("lat",myLatitude);
                            userInfo.put("long",myLongitude);
                            currentUserDb.updateChildren(userInfo);


                        }
                    }
                });
            }
        });











    }

    public void locationRequest(){
        LocationRequest locationRequest = new LocationRequest()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(5000)
                .setFastestInterval(5000);
        EasyLocationRequest easyLocationRequest = new EasyLocationRequestBuilder()
                .setLocationRequest(locationRequest)
                .setFallBackToLastLocationTime(3000)
                .build();

        requestLocationUpdates(easyLocationRequest);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    public void onLocationPermissionGranted() {

    }

    @Override
    public void onLocationPermissionDenied() {


    }

    @Override
    public void onLocationReceived(Location location) {



        try{
            Geocoder geo = new Geocoder(this.getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geo.getFromLocation(location.getLatitude(),location.getLongitude(), 1);
            if (addresses.isEmpty()) {
                locationTextBox.setText("Waiting for Location");
            }
            else {
                if (addresses.size() > 0) {
                    locationTextBox.setText(addresses.get(0).getFeatureName() + "," + addresses.get(0).getLocality() +"," + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName() + "DISTANCE =" + (calculateDistance(location.getLatitude(),location.getLongitude()))/1000+"");

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        myLatitude = location.getLatitude();
        myLongitude = location.getLongitude();

        //idhar se coordintes le le...........
        System.out.println("coordinates:"+"lat="+location.getLatitude()+" lon="+location.getLongitude()+" accuracy="+location.getAccuracy());
    }



    @Override
    public void onLocationProviderEnabled() {

    }

    @Override
    public void onLocationProviderDisabled() {

    }

    public double calculateDistance(Double lat1,Double lon1) {
        Double lat2 = 21.2513844;
        Double lon2 = 81.6296413;


        Location startPoint = new Location("locationA");
        startPoint.setLatitude(lat1);
        startPoint.setLongitude(lon1);

        Location endPoint = new Location("locationA");
        endPoint.setLatitude(lat2);
        endPoint.setLongitude(lon2);

        double distance = startPoint.distanceTo(endPoint);

        return distance;
    }








}

