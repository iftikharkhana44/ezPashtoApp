package com.finalyearproject.learnpashto;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersCategoryActivity extends AppCompatActivity {

    /**Handles playback of all the sound files*/
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                        // our app is allowed to continue playing sound but at a lower volume. We'll treat
                        // both cases the same way because our app is playing short sound files.

                        // Pause playback and reset player to the start of the file. That way, we can
                        // play the word from the beginning when we resume playback.
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                        mMediaPlayer.start();
                    }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                        // Stop playback and clean up resources
                        releaseMediaPlayer();
                    }
                }
            };

    /**
     * This listener gets triggerd when the @Link MediaPlayer has completed
     * playing the audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
            }
        };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.word_list);
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);

            // Create and setup the @link AudioManager to request audio focus
            mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            final ArrayList<Word> words = new ArrayList<Word>();

            words.add(new Word("One","Yaw",R.drawable.numbers_one, R.raw.one));
            words.add(new Word("Two","Dwa",R.drawable.numbers_two, R.raw.two));
            words.add(new Word("Three","Dre",R.drawable.numbers_three, R.raw.three));
            words.add(new Word("Four","Calor",R.drawable.numbers_four, R.raw.four));
            words.add(new Word("Five","Pinza",R.drawable.numbers_five, R.raw.five));
            words.add(new Word("Six","Shpag",R.drawable.numbers_six, R.raw.six));
            words.add(new Word("Seven","Owa",R.drawable.numbers_seven, R.raw.seven));
            words.add(new Word("Eight","Ata",R.drawable.numbers_eight, R.raw.eight));
            words.add(new Word("Nine","Nah",R.drawable.numbers_nine, R.raw.nine));
            words.add(new Word("Ten","Las",R.drawable.numbers_ten, R.raw.ten));

            WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(adapter);
            //  Set a click listener to play the audio when the list item is clicked on
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Get the @link Word object at the given position the user clicked on
                    Word word = words.get(position);

                    // Release the media player if it currently exists because we are about to
                    //play a different sound file.
                    releaseMediaPlayer();

                    //Request audio focus for playback
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            // Use the music stream
                            AudioManager.STREAM_MUSIC,
                            //Request permanent focus
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        // Create and setup the @link MediaPlayer for the audio resource associated
                        // with the current word
                        mMediaPlayer = MediaPlayer.create(NumbersCategoryActivity.this, word.getaAudio());

                        //Start the audio file
                        mMediaPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
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
        @Override
        protected void onStop() {
            super.onStop();
            // When the activity is stopped then release the media player resource because we won't
            // be playing it anymore
            releaseMediaPlayer();
        }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of weather or not we were granted audio focus, abandon it. This
            // also unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }
}