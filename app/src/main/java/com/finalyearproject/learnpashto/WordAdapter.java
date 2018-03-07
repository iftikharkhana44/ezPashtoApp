package com.finalyearproject.learnpashto;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word>{

    private int backgroundColour;

    public WordAdapter(Activity context, ArrayList<Word> words, int bBackgroundColour){
        super(context, 0, words);
        backgroundColour = bBackgroundColour;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView pashtoTextView = (TextView) listItemView.findViewById(R.id.Pashto_text_view);
        pashtoTextView.setText(currentWord.getpPashto());

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.English_text_view);
        englishTextView.setText(currentWord.geteEnglish());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getiImage());
            imageView.setVisibility(convertView.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), backgroundColour);
        textContainer.setBackgroundColor(color);
        return listItemView;

    }
}
