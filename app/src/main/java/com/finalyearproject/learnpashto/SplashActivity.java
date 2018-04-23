package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    //field for the image object
    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //find the imageView from the activity_splash.xml
        im = (ImageView) findViewById(R.id.im);
        //new Animation object referencing the transition xml inside the anim directory
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.transition);
        im.startAnimation(anim);
        final Intent i = new Intent(this,MainActivity.class);

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
