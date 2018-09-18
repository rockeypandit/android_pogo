package com.example.rockeypandit.pogo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);


        ImageView imgLogo = (ImageView) findViewById(R.id.imglogo);
        final Snackbar snackbar = Snackbar.make(imgLogo, "NO INTERNET CONNECTION", Snackbar.LENGTH_INDEFINITE);
        Animation slideup = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        imgLogo.startAnimation(slideup);


        Thread timer = new Thread() {
            public void run() {
                try {


                    sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {


                    while (!(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
                        //we are connected to a network

                        snackbar.show();


                    }

                    snackbar.dismiss();


                    try {


                        sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        if(FirebaseAuth.getInstance().getCurrentUser()!=null){

                        }




                        //YOUR CODE HERE


                    }
                   // startActivity(i);

                    finish();

                }
            }

        };
        timer.start();

System.out.print("");


    }
}
