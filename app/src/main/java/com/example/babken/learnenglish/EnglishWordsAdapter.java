package com.example.babken.learnenglish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Babken on 14.05.2017.
 */

public class EnglishWordsAdapter extends ArrayAdapter<EnglishWords> {

    public EnglishWordsAdapter(Activity context , ArrayList<EnglishWords> englishWordses) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, englishWordses);


    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        EnglishWords currentEnglisWords = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.english_word);
        nameTextView.setText(currentEnglisWords.getWord());
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.translation_id);
        numberTextView.setText(currentEnglisWords.getTranslation());

        return listItemView;
    }
}
