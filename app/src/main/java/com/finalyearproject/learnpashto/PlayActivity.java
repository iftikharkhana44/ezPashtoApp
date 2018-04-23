package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    Button quiz, scoreboard, instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        scoreboard = (Button) findViewById(R.id.score);
        quiz = (Button) findViewById(R.id.quiz);
        instructions = (Button) findViewById(R.id.instruction);


        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quiz_Intent = new Intent(PlayActivity.this, QuizActivity.class);
                startActivity(quiz_Intent);
            }
        });
        scoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent score_Intent = new Intent(PlayActivity.this, scoreboardActivity.class);
                startActivity(score_Intent);
            }
        });
        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructions_Intent = new Intent(PlayActivity.this, quizInstructionActivity.class);
                startActivity(instructions_Intent);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
