package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        Button quiz = (Button) findViewById(R.id.quiz);

        quiz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Learn View is clicked on.
            @Override
            public void onClick(View view) {
                Intent quiz_Intent = new Intent(PlayActivity.this, ColoursQuiz.class);
                startActivity(quiz_Intent);
            }
        });

    }
}
