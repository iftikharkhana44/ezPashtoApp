package com.finalyearproject.learnpashto.data;

import android.provider.BaseColumns;

public class ScoreContract {

    public static class ScoreEntry implements BaseColumns {
        public final static String TABLE_NAME = "scores";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "Name";
        public final static String COLUMN_SCORE = "Score";
    }
}
