package com.example.watsana.prospecappraisal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.watsana.prospec.all_land_and_building.HomeActivity;
import com.example.watsana.prospec.bank_ghb.BankActivity;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private static int SPLASH_TIME_OUT = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, LoginFragment.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

    } // Main Method
} //Main Class


