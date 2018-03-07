package com.finalyearproject.learnpashto;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HP on 24/02/2018.
 */

public class DaysActivity extends AppCompatActivity {
    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer audioPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                        // our app is allowed to continue playing sound but at a lower volume. We'll treat
                        // both cases the same way because our app is playing short sound files.

                        // Pause playback and reset player to the start of the file. That way, we can
                        // play the word from the beginning when we resume playback.
                        audioPlayer.pause();
                        audioPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                        audioPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
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

        words.add(new Word("Day", "Wraz",R.raw.day ));
        words.add(new Word("Today","Nen", R.raw.today));
        words.add(new Word("Yesterday","Parun", R.raw.yesterday));
        words.add(new Word("Tomorrow","Sabaa", R.raw.tomorrow));
        words.add(new Word("Day after tomorrow","saba na Bel sa-baa", R.raw.day_after_tomorrow));
        words.add(new Word("Next week","bala haafta", R.raw.next_week));
        words.add(new Word("This week","Da haapta", R.raw.this_week));
        words.add(new Word("last week","Tera shawey haafta ", R.raw.last_week));
        words.add(new Word("Monday","Naswari", R.raw.brown));
        words.add(new Word("Tuesday","Naswari", R.raw.brown));
        words.add(new Word("Wednesday","Charshamba", R.raw.wednesday));
        words.add(new Word("Thursday","Ziarat", R.raw.thursday));
        words.add(new Word("Friday","Jumma", R.raw.friday));
        words.add(new Word("Saturday","Khali", R.raw.saturday));
        words.add(new Word("Sunday","Atwar", R.raw.sunday));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_days);

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
                    audioPlayer = MediaPlayer.create(DaysActivity.this, word.getaAudio());

                    //Start the audio file
                    audioPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing
                    audioPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
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
        if (audioPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            audioPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            audioPlayer = null;

            // Regardless of weather or not we were granted audio focus, abandon it. This
            // also unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}