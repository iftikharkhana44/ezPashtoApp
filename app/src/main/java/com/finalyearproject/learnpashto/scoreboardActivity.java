package com.finalyearproject.learnpashto;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.finalyearproject.learnpashto.data.ScoreContract.ScoreEntry;
import com.finalyearproject.learnpashto.data.ScoreBoardDbHelper;

public class scoreboardActivity extends AppCompatActivity {

    //fields
    private ScoreBoardDbHelper mDbhelper;
    private TextView displayNameTitle;
    private TextView displayScoreTitle;
    private TextView displayName;
    private TextView displayScore;

    //code executed when the activity is first loaded
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        //get support for
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDbhelper = new ScoreBoardDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        SQLiteDatabase db = mDbhelper.getReadableDatabase();

        String[] projection = {
                ScoreEntry.COLUMN_NAME,
                ScoreEntry.COLUMN_SCORE };

        Cursor cursor = db.query(
                ScoreEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        Cursor cursor2 = db.query(
                ScoreEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        displayNameTitle = (TextView) findViewById(R.id.userNameTitle);
        displayScoreTitle = (TextView) findViewById(R.id.userScoreTitle);
        displayName = (TextView) findViewById(R.id.userName);
        displayScore = (TextView) findViewById(R.id.userScore);

        try {
            displayNameTitle.append(ScoreEntry.COLUMN_NAME +"\n");
            displayScoreTitle.append(ScoreEntry.COLUMN_SCORE +"\n");

            int nameColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_NAME);
            int scoreColumnIndex = cursor.getColumnIndex(ScoreEntry.COLUMN_SCORE);

            while (cursor.moveToNext()) {
                String currentName = cursor.getString(nameColumnIndex);
                displayName.append(("\n" + currentName));
            }
            while (cursor2.moveToNext()) {
                String currentScore = cursor2.getString(scoreColumnIndex);
                displayScore.append(("\n" + currentScore));
            }
        } finally {
            cursor.close();
            cursor2.close();
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