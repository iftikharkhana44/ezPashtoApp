package com.finalyearproject.learnpashto;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.high_score);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultLabel.setText(score + " / 8");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("High score : " + score);

            //update total score.
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("TotalScore ", highScore);
            editor.commit();
        }else {
            highScoreLabel.setText("High score : " + highScore);
        }
    }
}
