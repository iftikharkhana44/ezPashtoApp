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

public class AlphabetsCategoryActivity extends AppCompatActivity {

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

            words.add(new Word("","Alef",R.drawable.alef, R.raw.audio_comingsoon));
            words.add(new Word("","Beh",R.drawable.beh, R.raw.audio_comingsoon));
            words.add(new Word("","Peh",R.drawable.peh, R.raw.audio_comingsoon));
            words.add(new Word("","Theh",R.drawable.theh, R.raw.audio_comingsoon));
            words.add(new Word("","Tteh",R.drawable.tteh, R.raw.audio_comingsoon));
            words.add(new Word("","Theh",R.drawable.theh, R.raw.audio_comingsoon));
            words.add(new Word("","Jeem",R.drawable.jeem, R.raw.audio_comingsoon));
            words.add(new Word("","Zeem",R.drawable.zeem, R.raw.audio_comingsoon));
            words.add(new Word("","Tcheh",R.drawable.tcheh, R.raw.audio_comingsoon));
            words.add(new Word("","Seem",R.drawable.seem, R.raw.audio_comingsoon));
            words.add(new Word("","Heh",R.drawable.heh, R.raw.audio_comingsoon));
            words.add(new Word("","Kheh",R.drawable.kheh, R.raw.audio_comingsoon));
            words.add(new Word("","Dal",R.drawable.dal, R.raw.audio_comingsoon));
            words.add(new Word("","Ddal",R.drawable.ddal, R.raw.audio_comingsoon));
            words.add(new Word("","Zaal",R.drawable.ddal, R.raw.audio_comingsoon));
            words.add(new Word("","Reh",R.drawable.reh, R.raw.audio_comingsoon));
            words.add(new Word("","Rreh",R.drawable.rreh, R.raw.audio_comingsoon));
            words.add(new Word("","Geh",R.drawable.geh, R.raw.audio_comingsoon));
            words.add(new Word("","Zeh",R.drawable.zeh, R.raw.audio_comingsoon));
            words.add(new Word("","Zzeh",R.drawable.zzeh, R.raw.audio_comingsoon));
            words.add(new Word("","Seen",R.drawable.seen, R.raw.audio_comingsoon));
            words.add(new Word("","Sheen",R.drawable.sheen, R.raw.audio_comingsoon));
            words.add(new Word("","kheen",R.drawable.kheen, R.raw.audio_comingsoon));
            words.add(new Word("","sad",R.drawable.sad, R.raw.audio_comingsoon));
            words.add(new Word("","Dad",R.drawable.dad, R.raw.audio_comingsoon));
            words.add(new Word("","Tweh",R.drawable.tweh, R.raw.audio_comingsoon));
            words.add(new Word("","Zweh",R.drawable.zweh, R.raw.audio_comingsoon));
            words.add(new Word("","Ain",R.drawable.ain, R.raw.audio_comingsoon));
            words.add(new Word("","Ghain",R.drawable.ghain, R.raw.audio_comingsoon));
            words.add(new Word("","Feh",R.drawable.comingsoon, R.raw.audio_comingsoon));
            words.add(new Word("","Qaf",R.drawable.comingsoon, R.raw.audio_comingsoon));
            words.add(new Word("","Kaf",R.drawable.kaf, R.raw.audio_comingsoon));
            words.add(new Word("","Gaf",R.drawable.gaf, R.raw.audio_comingsoon));
            words.add(new Word("","Lam",R.drawable.lam, R.raw.audio_comingsoon));
            words.add(new Word("","Meem",R.drawable.meem, R.raw.audio_comingsoon));
            words.add(new Word("","Noon",R.drawable.noon, R.raw.audio_comingsoon));
            words.add(new Word("","Noorr",R.drawable.noorr, R.raw.audio_comingsoon));
            words.add(new Word("","Heh",R.drawable.heh, R.raw.audio_comingsoon));
            words.add(new Word("","Yeh",R.drawable.yeh, R.raw.audio_comingsoon));
            words.add(new Word("","Verbal Yeh",R.drawable.comingsoon, R.raw.audio_comingsoon));
            words.add(new Word("","Strong Yeh",R.drawable.strong_yeh, R.raw.audio_comingsoon));
            words.add(new Word("","Soft Yeh",R.drawable.soft_yeh, R.raw.audio_comingsoon));



            WordAdapter adapter = new WordAdapter(this, words, R.color.yellow);

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
                        mMediaPlayer = MediaPlayer.create(AlphabetsCategoryActivity.this, word.getaAudio());

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