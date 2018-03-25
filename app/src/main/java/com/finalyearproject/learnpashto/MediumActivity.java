package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MediumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        TextView Animals = (TextView) findViewById(R.id.Animals);

        // set an on click method on the Numbers view
        Animals.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersCategoryActivity
            @Override
            public void onClick(View view) {
                Intent animals_Intent = new Intent(MediumActivity.this, AnimalsCategoryActivity.class);
                startActivity(animals_Intent);
            }
        });

        TextView School = (TextView) findViewById(R.id.School);

        // set an on click method on the Numbers view
        School.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersCategoryActivity
            @Override
            public void onClick(View view) {
                Intent school_Intent = new Intent(MediumActivity.this, SchoolSuppliesCategoryActivity.class);
                startActivity(school_Intent);
            }
        });

        TextView Transport = (TextView) findViewById(R.id.Transport);

        // set an on click method on the Numbers view
        Transport.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersCategoryActivity
            @Override
            public void onClick(View view) {
                Intent transport_Intent = new Intent(MediumActivity.this, TransportationCategoryActivity.class);
                startActivity(transport_Intent);
            }
        });

        TextView body = (TextView) findViewById(R.id.body);

        // set an on click method on the Numbers view
        body.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersCategoryActivity
            @Override
            public void onClick(View view) {
                Intent body_Intent = new Intent(MediumActivity.this, BodyPartsCategoryActivity.class);
                startActivity(body_Intent);
            }
        });
    }
}
