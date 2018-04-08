package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultLabel;
    private Button btnTryAgain;
    private Button btnLearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultLabel = (TextView) findViewById(R.id.resultLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        int numberOfQuestions = getIntent().getIntExtra("NUMBER_OF_QUESTIONS", 0);
        resultLabel.setText(score + " out of " + numberOfQuestions);

        btnTryAgain = (Button) findViewById(R.id.again);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tryAgainIntent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(tryAgainIntent);
                finish();
            }
        });

        btnLearn = (Button) findViewById(R.id.learnQuiz);
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent learnQuizIntent = new Intent(ResultActivity.this, CategoryActivity.class);
                startActivity(learnQuizIntent);
                finish();
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