package com.finalyearproject.learnpashto;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

        private MediaPlayer mMediaPlayer;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.word_list);
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);

            final ArrayList<Word> words = new ArrayList<Word>();

            words.add(new Word("one","yaw",R.drawable.numbers_one, R.raw.number_one));
            words.add(new Word("two","dwa",R.drawable.numbers_two, R.raw.number_two));
            words.add(new Word("three","dre",R.drawable.numbers_three, R.raw.number_three));
            words.add(new Word("four","calor",R.drawable.numbers_four, R.raw.number_four));
            words.add(new Word("five","pinza",R.drawable.numbers_five, R.raw.number_five));
            words.add(new Word("six","shpag",R.drawable.numbers_six, R.raw.number_six));
            words.add(new Word("seven","owa",R.drawable.numbers_seven, R.raw.number_seven));
            words.add(new Word("eight","ata",R.drawable.numbers_eight, R.raw.number_eight));
            words.add(new Word("nine","nah",R.drawable.numbers_nine, R.raw.number_nine));
            words.add(new Word("ten","las",R.drawable.numbers_ten, R.raw.number_ten));

            WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Word word = words.get(position);
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getaAudio());
                    mMediaPlayer.start();
                }
            });
        }
    }