package com.ak.covid_19suppliers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UserRegistration extends AppCompatActivity {
    Button b1,b2;
    TextInputLayout e1,e2,e3,e4,e5;
    DatabaseHelper1 myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_registration);
        myDb=new DatabaseHelper1(this);
        b1=(Button)findViewById(R.id.register);
        b2=(Button)findViewById(R.id.register1);
        e1=(TextInputLayout)findViewById(R.id.fname);
        e2=(TextInputLayout)findViewById(R.id.lname);
        e3=(TextInputLayout)findViewById(R.id.username);
        e4=(TextInputLayout)findViewById(R.id.password);
        e5=(TextInputLayout)findViewById(R.id.password1);
        AddData();
        viewAll();
    }
    public void AddData() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted = myDb.insertData(e1.getEditText().getText().toString(), e2.getEditText().getText().toString(),e3.getEditText().getText().toString(), e4.getEditText().getText().toString());
                if (isinserted = true) {
                    Toast.makeText(UserRegistration.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserRegistration.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void viewAll(){
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=myDb.getAlldata();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID: "+res.getString(0)+"\n");
                    buffer.append("First Name: "+res.getString(1)+"\n");
                    buffer.append("Surname: "+res.getString(2)+"\n");
                    buffer.append("Username: "+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    }
