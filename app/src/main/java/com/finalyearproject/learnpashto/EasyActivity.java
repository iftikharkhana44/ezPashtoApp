package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EasyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        //here we find the views which show the play and learn options on the main screen
        TextView numbers = (TextView) findViewById(R.id.Numbers);

        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Animal View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntenet = new Intent(EasyActivity.this, NumbersActivity.class);
                startActivity(numbersIntenet);
            }
        });
    }
}
