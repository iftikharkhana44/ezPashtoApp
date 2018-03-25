package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        TextView music = (TextView) findViewById(R.id.Music);

        // set an on click method on the Numbers view
        music.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersCategoryActivity
            @Override
            public void onClick(View view) {
                Intent music_Intent = new Intent(HardActivity.this, BodyPartsCategoryActivity.class);
                startActivity(music_Intent);
            }
        });
    }
}
