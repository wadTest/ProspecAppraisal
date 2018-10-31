
package com.example.watsana.prospecappraisal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.watsana.prospec.fragment.LandTab1Fragment;

public class FormLandActivity extends AppCompatActivity {

//    Explicit
private int indexAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_bank);

//        Get Index

        getIndex();

//        Add Fragment
        if (savedInstanceState == null) {

            switch (indexAnInt) {

                case 0:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentFormLandFragment, new LoginFragment())
                            .commit();
                    break;
            }
        }


    }//Main method

    private void getIndex() {
        indexAnInt = getIntent().getIntExtra("Index",0);
        Log.d("170ctV1", "index ==>" + indexAnInt);
    }
}//Main Class
