package com.example.babken.learnenglish.readClassActivities;

import android.content.ContentValues;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babken.learnenglish.EnglishWordsAdapter;
import com.example.babken.learnenglish.MainActivity;
import com.example.babken.learnenglish.R;
import com.example.babken.learnenglish.date.EnglishWordContract;
import com.example.babken.learnenglish.date.EnglishWordsReaderDbHelper;

/**
 * Created by Babken on 16.05.2017.
 */

public class ReadCategoryOneActivity extends AppCompatActivity {
    EnglishWordsReaderDbHelper dbHelper;
    SQLiteDatabase db;
    EnglishWordsAdapter englishWordsesAdapter;

    String deleteText = "Deleted";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_activity);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);;
        englishWordsesAdapter = new   EnglishWordsAdapter(this, MainActivity.englishCategoryTwoWordses);
        dbHelper=new EnglishWordsReaderDbHelper(this);
        db = dbHelper.getWritableDatabase();


        // Get a reference to the ListView, and attach the adapter to the listView.

      final   ListView listView = (ListView) findViewById(R.id.listview_english_words);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                //get  current  TextView
                TextView englishWordTextView=(TextView)view.findViewById(R.id.english_word);
                TextView translationTextview=(TextView)view.findViewById(R.id.translation_id);
                //Update database
                ContentValues values = new ContentValues();
                values.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE,(String) null);
                values.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE_TRANSLATE,(String)null);
                String[] arg= new String[]{englishWordTextView.getText().toString()};
                db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE +"=?", arg);
                //delete selected itemfrom  array
                MainActivity.englishCategoryTwoWordses.remove(position);
                listView.setAdapter( englishWordsesAdapter);
                //set Toast
                Toast toast =Toast.makeText(getApplicationContext(),deleteText+" "+englishWordTextView.getText()+" - "+translationTextview.getText(),Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });

        listView.setAdapter( englishWordsesAdapter);
    }
}
