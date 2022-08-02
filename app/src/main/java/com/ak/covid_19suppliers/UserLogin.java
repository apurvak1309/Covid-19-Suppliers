package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UserLogin extends AppCompatActivity {
    Button b1;
    TextInputLayout e1, e2;
    DatabaseHelper1 myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_login);
        myDb = new DatabaseHelper1(this);
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
                    Toast.makeText(UserLogin.this,"Error: Nothing Found",Toast.LENGTH_SHORT).show();
                    return;
                }
                while (res.moveToNext()) {
                    if (e1.getEditText().getText().toString().equals(res.getString(3)) &&
                            e2.getEditText().getText().toString().equals(res.getString(4))) {
                        Intent i=new Intent(UserLogin.this,WelcomePageUser.class);
                        i.putExtra("username",e1.getEditText().getText().toString());
                        startActivity(i);
                        finish();
                        break;
                    } else {
                        Toast.makeText(UserLogin.this,"Login Unsuccessful!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
    }
