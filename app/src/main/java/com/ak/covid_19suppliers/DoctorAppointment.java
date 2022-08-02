package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class DoctorAppointment extends AppCompatActivity {
    String a;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_appointment);
        t1=(TextView)findViewById(R.id.logo_text);
        Intent i=getIntent();
        a=i.getExtras().getString("username");
        t1.setText("Welcome: "+a+" !");
    }
}