package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LearningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);


        //here we find the views which show the play and learn options on the main screen
        LinearLayout easy = (LinearLayout) findViewById(R.id.btnEasy);
        LinearLayout medium = (LinearLayout) findViewById(R.id.btnMedium);
        LinearLayout hard = (LinearLayout) findViewById(R.id.btnHard);
        final LinearLayout veryHard = (LinearLayout) findViewById(R.id.btnVeryHard);

        easy.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Learn View is clicked on.
            @Override
            public void onClick(View view) {
                Intent easyIntent = new Intent(LearningActivity.this, EasyActivity.class);
                startActivity(easyIntent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Play view is clicked on.
            @Override
            public void onClick(View view) {
                Intent mediumIntent = new Intent(LearningActivity.this, MediumActivity.class);
                startActivity(mediumIntent);
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Play view is clicked on.
            @Override
            public void onClick(View view) {
                Intent hardIntent = new Intent(LearningActivity.this, HardActivity.class);
                startActivity(hardIntent);
            }
        });

        veryHard.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Play view is clicked on.
            @Override
            public void onClick(View view) {
                Intent veryHardIntent = new Intent(LearningActivity.this, veryHardActivity.class);
                startActivity(veryHardIntent);
            }
        });
    }
}
