package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_page);
        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button1);
        b3=(Button) findViewById(R.id.button2);
        b4=(Button)findViewById(R.id.button3);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent i=new Intent(MainPage.this,DoctorLogin.class);
                startActivity(i);
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(MainPage.this,DoctorRegistration.class);
               startActivity(i);
           }
       });
       b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(MainPage.this,UserLogin.class);
               startActivity(i);
           }
       });
       b4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(MainPage.this,UserRegistration.class);
               startActivity(i);
           }
       });
    }
}