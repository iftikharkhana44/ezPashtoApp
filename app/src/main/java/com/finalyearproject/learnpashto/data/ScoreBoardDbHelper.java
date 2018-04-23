package com.finalyearproject.learnpashto.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.finalyearproject.learnpashto.data.ScoreContract.ScoreEntry;

public class ScoreBoardDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";

    private static final int DATABASE_VERSION = 1;

    public ScoreBoardDbHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_SCORE_BOARD_TABLE =  "CREATE TABLE " + ScoreEntry.TABLE_NAME + " ("
                + ScoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ScoreEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + ScoreEntry.COLUMN_SCORE + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_SCORE_BOARD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
