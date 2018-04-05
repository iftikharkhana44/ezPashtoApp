package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    Button quiz;
    Button backTOMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quiz_Intent = new Intent(PlayActivity.this, EasyQuiz.class);
                startActivity(quiz_Intent);
            }
        });

        backTOMain = (Button) findViewById(R.id.backtomain);
        backTOMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }
}
