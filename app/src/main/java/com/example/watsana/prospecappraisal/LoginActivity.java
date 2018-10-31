package com.example.watsana.prospecappraisal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

//  Explicit
    private Button button ,buttonDate ,buttonDate1, buttonDate2;
    private EditText EditTextDate, EditTextDate1, EditTextDate2;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.button);

//      ผู้ใช้งาน
        buttonDate = (Button) findViewById(R.id.buttonDate);
        EditTextDate = (EditText) findViewById(R.id.EditTextDate);

//      ผู้ประเมินหลัก
        buttonDate1 = (Button) findViewById(R.id.buttonDate1);
        EditTextDate1 = (EditText) findViewById(R.id.EditTextDate1);

//      ผู้รับมอบอำนาจ
        buttonDate2 = (Button) findViewById(R.id.buttonDate2);
        EditTextDate2 = (EditText) findViewById(R.id.EditTextDate2);


////      Get Event From Click Save
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, BankActivity.class);
//                intent.putExtra("Login",0);
//                startActivity(intent);
//            }
//        });

//      DatePicker
        buttonDate.setOnClickListener(this);
        buttonDate1.setOnClickListener(this);
        buttonDate2.setOnClickListener(this);

    } // Main Method

    @Override
    public void onClick(View v) {
//      DD/MM/YYYY ผู้ใช้งาน
        if (v==buttonDate){
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                    EditTextDate.setText(dayOfMonth + "/" + (monthofYear + 1) + "/" + year);
                }
            }, dia, mes, ano);
            datePickerDialog.show();
        }

//      DD/MM/YYYY ผู้ประเมินหลัก
        if (v == buttonDate1) {
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                    EditTextDate1.setText(dayOfMonth + "/" + (monthofYear + 1) + "/" + year);
                }
            }, dia, mes, ano);
            datePickerDialog.show();
        }

//      DD/MM/YYYY ผู้รับมอบอำนาจ
        if (v == buttonDate2) {
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            ano = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                    EditTextDate2.setText(dayOfMonth + "/" + (monthofYear + 1) + "/" + year);
                }
            }, dia, mes, ano);
            datePickerDialog.show();
        }
    }
} //Main Class