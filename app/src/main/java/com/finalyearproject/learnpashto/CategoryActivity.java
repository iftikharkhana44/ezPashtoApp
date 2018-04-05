package com.finalyearproject.learnpashto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        Button numbers = (Button) findViewById(R.id.numbers);
        Button colours = (Button) findViewById(R.id.colours);
        Button food = (Button) findViewById(R.id.food);
        Button animals = (Button) findViewById(R.id.animals);
        Button body = (Button) findViewById(R.id.body);
        Button alphabets  = (Button) findViewById(R.id.alphabets );

        numbers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent numbers_Intent = new Intent(CategoryActivity.this, NumbersCategoryActivity.class);
                startActivity(numbers_Intent);
            }
        });

        colours.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent colours_Intent = new Intent(CategoryActivity.this, ColoursCategoryActivity.class);
                startActivity(colours_Intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent food = new Intent(CategoryActivity.this, FoodCategoryActivity.class);
                startActivity(food);
            }
        });

        animals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent animals_Intent = new Intent(CategoryActivity.this, AnimalsCategoryActivity.class);
                startActivity(animals_Intent);
            }
        });

        body.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent body_Intent = new Intent(CategoryActivity.this, BodyPartsCategoryActivity.class);
                startActivity(body_Intent);
            }
        });

        alphabets.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent alphabets_Intent = new Intent(CategoryActivity.this, AlphabetsCategoryActivity.class);
                startActivity(alphabets_Intent);
            }
        });
    }
}