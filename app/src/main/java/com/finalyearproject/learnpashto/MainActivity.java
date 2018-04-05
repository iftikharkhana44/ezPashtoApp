package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here we find the views which show the play and learn options on the main screen
        Button learn = (Button) findViewById(R.id.btnlearn);
        final Button play = (Button) findViewById(R.id.btnplay);

        learn.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Learn View is clicked on.
            @Override
            public void onClick(View view) {
                Intent learnIntent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(learnIntent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Play view is clicked on.
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(playIntent);
            }
        });
    }
}
