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

public class FoodCategoryActivity extends AppCompatActivity {

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

            words.add(new Word("Apple", "Maana", R.drawable.apple, R.raw.applemana));
            words.add(new Word("Banana", "Kaila", R.drawable.comingsoon, R.raw.bananakela));
            words.add(new Word("Grapes", "kwar", R.drawable.grapes, R.raw.grapekwar));
            words.add(new Word("Pomegranate", "Anar", R.drawable.comingsoon, R.raw.pomigranetannar));
            words.add(new Word("Orange", "Malta", R.drawable.orange, R.raw.orangemalta));
            words.add(new Word("Watermelon", "Hindwana", R.drawable.watermelon, R.raw.watermelonhindwana));
            words.add(new Word("Apricot", "Khobani", R.drawable.comingsoon, R.raw.apricotkhobani));
            words.add(new Word("Plum", "Aloocha", R.drawable.comingsoon, R.raw.plumalocha));
            words.add(new Word("Cabbage", "Band Gopi", R.drawable.comingsoon, R.raw.cabbagebandgopi));
            words.add(new Word("Coconut", "Kopra", R.drawable.comingsoon, R.raw.coconutkopra));
            words.add(new Word("Corn", "Waggay", R.drawable.comingsoon, R.raw.sweetcornwaggay));
            words.add(new Word("Eggplant", "Bantingun", R.drawable.comingsoon, R.raw.eggplantbatigun));
            words.add(new Word("Garlic", "Ooga", R.drawable.comingsoon, R.raw.garlicogga));
            words.add(new Word("Green peas", "Mattur", R.drawable.comingsoon, R.raw.peasmattar));
            words.add(new Word("Lemon", "Nimbu", R.drawable.lemon, R.raw.lemonnimbu));
            words.add(new Word("Mango", "Aam", R.drawable.comingsoon, R.raw.mangoaam));
            words.add(new Word("Onion", "Piyaz", R.drawable.comingsoon, R.raw.onionpyaz));
            words.add(new Word("Peach", "Shaltalu", R.drawable.comingsoon, R.raw.peachshaltalu));
            words.add(new Word("Pear", "Nashpatay", R.drawable.pear, R.raw.pearnashpatay));
            words.add(new Word("Pineapple", "Ananas", R.drawable.pineapple, R.raw.pineappleannas));
            words.add(new Word("Potato", "Aloo", R.drawable.comingsoon, R.raw.potatoaloo));
            words.add(new Word("Pumpkin", "Kaddu", R.drawable.comingsoon, R.raw.pumpkinkadu));
            words.add(new Word("Spinach", "Paluk", R.drawable.comingsoon, R.raw.spinachpaluk));

            WordAdapter adapter = new WordAdapter(this, words, R.color.category_food);

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
                        audioPlayer = MediaPlayer.create(FoodCategoryActivity.this, word.getaAudio());

                        //Start the audio file
                        audioPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing
                        audioPlayer.setOnCompletionListener(mCompletionListener);
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