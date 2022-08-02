package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DoctorLogin extends AppCompatActivity {
    Button b1;
    TextInputLayout e1, e2;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_login);
        myDb = new DatabaseHelper(this);
        b1 = (Button) findViewById(R.id.login);
        e1 = (TextInputLayout) findViewById(R.id.username);
        e2 = (TextInputLayout) findViewById(R.id.password);
        viewAll();
        //boolean isinserted= myDb.insertData("Apurva","Kadam");
    }
    public void viewAll() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAlldata();
                if (res.getCount() == 0) {
                    Toast.makeText(DoctorLogin.this,"Error: Nothing Found",Toast.LENGTH_SHORT).show();
                    return;
                }
                while (res.moveToNext()) {
                    if (e1.getEditText().getText().toString().equals(res.getString(3)) &&
                            e2.getEditText().getText().toString().equals(res.getString(4))) {
                        Intent i=new Intent(DoctorLogin.this,WelcomePage.class);
                        i.putExtra("username",e1.getEditText().getText().toString());
                        startActivity(i);
                        break;
                    } else {
                        Toast.makeText(DoctorLogin.this,"Login Unsuccessful!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
}