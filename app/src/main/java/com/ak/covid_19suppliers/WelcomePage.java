package com.ak.covid_19suppliers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {
    TextView t1;
    String a;
    ImageView i1;
    private static int SPLASH_SCREEN=5000;
    Animation bottomAnim,topAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_page);
        t1=(TextView)findViewById(R.id.textView);
        i1=(ImageView)findViewById(R.id.imageView);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        Intent i=getIntent();
        a=i.getExtras().getString("username");
        t1.setText("Welcome: \n"+a+" !");

        i1.setAnimation(topAnim);
        t1.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomePage.this,DoctorAppointment.class);
                intent.putExtra("username",a);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(i1,"logo_image");
                pairs[1]=new Pair<View,String>(t1,"logo_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(WelcomePage.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            }
        },SPLASH_SCREEN);
    }
}