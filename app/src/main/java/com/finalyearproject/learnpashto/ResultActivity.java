package com.finalyearproject.learnpashto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.finalyearproject.learnpashto.data.ScoreBoardDbHelper;
import com.finalyearproject.learnpashto.data.ScoreContract.ScoreEntry;

public class ResultActivity extends AppCompatActivity {

    private TextView resultLabel;


    private Button btnTryAgain;
    private Button btnAdd;
    private Button btnLearn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultLabel = (TextView) findViewById(R.id.resultLabel);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        editText = (EditText) findViewById(R.id.editText);
        btnLearn = (Button) findViewById(R.id.learnQuiz);
        btnTryAgain = (Button) findViewById(R.id.again);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultLabel.setText(score + " ");

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tryAgainIntent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(tryAgainIntent);
                finish();
            }
        });

        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent learnQuizIntent = new Intent(ResultActivity.this, CategoryActivity.class);
                startActivity(learnQuizIntent);
                finish();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertScore();
            }
        });
    }

    private void insertScore() {

        String nameString = editText.getText().toString().trim();
        String scoreString = resultLabel.getText().toString().trim();
        int score = Integer.parseInt(scoreString);

        ScoreBoardDbHelper mDbHelper = new ScoreBoardDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ScoreEntry.COLUMN_NAME, nameString);
        values.put(ScoreEntry.COLUMN_SCORE, score);

        long newRowId = db.insert(ScoreEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error with saving", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
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