package com.example.watsana.prospecappraisal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class BankActivity extends AppCompatActivity {
    ImageView imageView, imageView1;
//    private String myNameLoginString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

//        myNameLoginString = "Prospec";

        imageView =  findViewById(R.id.imageView);
        imageView1 =  findViewById(R.id.imageView1);

//        //Get Event From Click Menu Land and Building
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(BankActivity.this, HomeActivity.class);
//                intent.putExtra("Main", myNameLoginString);
//                startActivity(intent);
//            }
//        });


//        //Get Event From Click Bank GHB
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(BankActivity.this, BankGHB01Activity.class);
//                intent.putExtra("BANK_GHB", myNameLoginString);
//                startActivity(intent);
//            }
//        });
    }
}
