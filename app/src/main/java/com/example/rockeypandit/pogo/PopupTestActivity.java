package com.example.rockeypandit.pogo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

import java.util.HashMap;
import java.util.Map;

public class PopupTestActivity extends AppCompatActivity {
    EditText name;
    String userName;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);
        name=findViewById(R.id.name);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=name.getText().toString();
                if (userName.length()==0){
                    name.setError("Please enter user name");
                }
                else{
                    Toast.makeText(PopupTestActivity.this, "sahi h sab", Toast.LENGTH_SHORT).show();
                    StartSmartAnimation.startAnimation( findViewById(R.id.c1) , AnimationType.FadeOut , 500 , 0 , true );
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    findViewById(R.id.c2).setVisibility(View.VISIBLE);
                                }
                            },300);
                            StartSmartAnimation.startAnimation( findViewById(R.id.c2) , AnimationType.ZoomInUp , 500 , 0 , true );
                        }
                    },300);

                }

            }
        });



    }


}
