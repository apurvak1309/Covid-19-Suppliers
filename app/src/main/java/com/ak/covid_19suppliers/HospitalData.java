package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputLayout;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class HospitalData extends AppCompatActivity {
    String a;
    TextView t1;
    TextInputLayout t;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hospital_data);
        t1=(TextView)findViewById(R.id.logo_text);
        b1=(Button)findViewById(R.id.button);
        Intent i=getIntent();
        a=i.getExtras().getString("username");
        t1.setText("Welcome: "+a+"!");
    }
    public void order(View v){
        try {
            AssetManager am=getAssets();
            InputStream is=am.open("data.xls");
            Workbook wb=Workbook.getWorkbook(is);
            Sheet s=wb.getSheet(0);
            int rows=s.getRows();
            int cols=s.getColumns();
            String xx="";
            for(int i=1;i<rows;i++){
                for(int j=0;j<cols;j++){
                    Cell z=s.getCell(j,i);
                    xx=xx+z.getContents();
                    xx=xx+"\t\t\t";
                }
                xx=xx+"\n";
            }
            display(xx);
        }catch (Exception e){

        }
    }
    public void display(String value){
        TextView t=(TextView)findViewById(R.id.data);
        t.setText(value);
    }
}