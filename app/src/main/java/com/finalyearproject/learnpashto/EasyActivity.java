package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EasyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);


        TextView numbers = (TextView) findViewById(R.id.Numbers);

        // set an on click method on the Numbers view
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Numbers View is clicked on.
            // This will start the NumbersActivity
            @Override
            public void onClick(View view) {
                Intent numbers_Intent = new Intent(EasyActivity.this, NumbersActivity.class);
                startActivity(numbers_Intent);
            }
        });

        TextView colours = (TextView) findViewById(R.id.Colours);

        colours.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Colours View is clicked on.
            // This will start the Colours activity
            @Override
            public void onClick(View view) {
                Intent colours_Intent = new Intent(EasyActivity.this, ColoursActivity.class);
                startActivity(colours_Intent);
            }
        });

        TextView days = (TextView) findViewById(R.id.Days);

        days.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Colours View is clicked on.
            // This will start the Colours activity
            @Override
            public void onClick(View view) {
                Intent days_Intent = new Intent(EasyActivity.this, DaysActivity.class);
                startActivity(days_Intent);
            }
        });

        TextView FruitVegetable = (TextView) findViewById(R.id.Fruit_Vegetable);

        FruitVegetable.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Colours View is clicked on.
            // This will start the Colours activity
            @Override
            public void onClick(View view) {
                Intent Fruit_Vegetable_Intent = new Intent(EasyActivity.this, FruitVegtableActivity.class);
                startActivity(Fruit_Vegetable_Intent);
            }
        });
    }
}
