package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultLabel;
    private Button btntryAgain;
    private Button btnlearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultLabel = (TextView) findViewById(R.id.resultLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultLabel.setText(score + " out of " + EasyQuiz.getQuizCount());

        btntryAgain = (Button) findViewById(R.id.again);
        btntryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tryagainIntent = new Intent(ResultActivity.this, EasyQuiz.class);
                startActivity(tryagainIntent);
                finish();
            }
        });

        btnlearn = (Button) findViewById(R.id.learnQuiz);
        btnlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent learnQuizIntent = new Intent(ResultActivity.this, CategoryActivity.class);
                startActivity(learnQuizIntent);
                finish();
            }
        });
    }
}