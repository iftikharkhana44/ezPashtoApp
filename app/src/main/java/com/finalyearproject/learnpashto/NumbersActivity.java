package com.finalyearproject.learnpashto;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HP on 08/02/2018.
 */

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Yaw", R.raw.number_one));
        words.add(new Word("two", "dwa", R.raw.number_two));
        words.add(new Word("three", "dre", R.raw.number_three));
        words.add(new Word("four", "calor", R.raw.number_four));
        words.add(new Word("five", "pinza", R.raw.number_five));
        words.add(new Word("six", "shpag", R.raw.number_six));
        words.add(new Word("seven", "owa", R.raw.number_seven));
        words.add(new Word("eight", "ata", R.raw.number_eight));
        words.add(new Word("nine", "nah", R.raw.number_nine));
        words.add(new Word("ten", "las", R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, words, R.color.background);

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
