package com.example.babken.learnenglish;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.babken.learnenglish.date.EnglishWordContract;
import com.example.babken.learnenglish.date.EnglishWordsReaderDbHelper;

import java.util.ArrayList;

/**
 * Created by Babken on 17.05.2017.
 */

public class AddActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Spinner spinner;
    Button button;
    EnglishWordsReaderDbHelper dbHelper;
    String[] catggorySpinnerList;
    Intent i;
    SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        editText1=(EditText)findViewById(R.id.edit_text_id);
        editText2=(EditText)findViewById(R.id.edit_text_id2);
        spinner=(Spinner)findViewById(R.id.spinner);
        button=(Button)findViewById(R.id.add_button);

        catggorySpinnerList=new String[5];

        dbHelper=new EnglishWordsReaderDbHelper(this);
        db = dbHelper.getWritableDatabase();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, R.layout.sppiner_item_list);
        adapter.setDropDownViewResource(R.layout.sppiner_inner);
        spinner.setAdapter(adapter);

    i=new Intent(AddActivity.this,MainActivity.class);
editText1.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN)
        {
            switch (i)
            {
                case KeyEvent.KEYCODE_ENTER:

                    //hide keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                    return true;
                default:
                    break;
            }
        }
        return false;
    }
});
        editText2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (i)
                    {
                        case KeyEvent.KEYCODE_ENTER:

                            //hide keyboard
                            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
switch (spinner.getSelectedItem().toString()){



    case "1":
        if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")){
        String word = editText1.getText().toString();
        String translation = editText2.getText().toString();
        MainActivity.englishCategoryTwoWordses.add(new EnglishWords(word,translation));
        //connect to database
        contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE, word);
        contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE_TRANSLATE, translation);
        long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, contentValues);
            startActivity(i);
    }

    else{
        editText1.setHint("Please write word");
        editText2.setHint("Please write word");
    }
break;


    case "2":
        if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")){
            String word = editText1.getText().toString();
            String translation = editText2.getText().toString();
            MainActivity.englishCategoryOneWordses.add(new EnglishWords(word,translation));
            //connect to database
            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO, word);
            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO_TRANSLATE, translation);
            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, contentValues);
            startActivity(i);
        }

        else{
            editText1.setHint("Please write word");
            editText2.setHint("Please write word");
        }
        break;

    case "3":

        if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")){
            String word = editText1.getText().toString();
            String translation = editText2.getText().toString();
            MainActivity.englishCategoryThreeWordses.add(new EnglishWords(word,translation));
            //connect ot database

            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE, word);
            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE_TRANSLATE, translation);
            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, contentValues);
            startActivity(i);
        }

        else{
            editText1.setHint("Please write word");
            editText2.setHint("Please write word");
        }
        break;

    case "4":
        if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")){
            String word = editText1.getText().toString();
            String translation = editText2.getText().toString();
            MainActivity.englishCategoryFourWordses.add(new EnglishWords(word,translation));
            //connect ot database

            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_FOUR, word);
            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_FILMS_CATEGORY_FOUR, translation);
            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, contentValues);
            startActivity(i);
        }

        else{
            editText1.setHint("Please write word");
            editText2.setHint("Please write word");
        }
        break;
    case  "5":
        if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")){
            String word = editText1.getText().toString();
            String translation = editText2.getText().toString();
            MainActivity.englishCategoryFiveWordses.add(new EnglishWords(word,translation));
            //connect ot database

            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME_CATEGORY_FIVE, word);
            contentValues.put(EnglishWordContract.EnglishWordEntry.COLUMN_NAME__CATEGORY_FIVE_TRANLSATE, translation);
            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, contentValues);
            startActivity(i);

        }

        else{
            editText1.setHint("Please write word");
            editText2.setHint("Please write word");
        }
        break;

        default:

         break;
}

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            int clearCount = db.delete(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, null);

            deleteArrayItems(MainActivity.englishCategoryTwoWordses);
            deleteArrayItems(MainActivity.englishCategoryOneWordses);
            deleteArrayItems(MainActivity.englishCategoryThreeWordses);
            deleteArrayItems(MainActivity.englishCategoryFourWordses);
            deleteArrayItems(MainActivity.englishCategoryFiveWordses);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void deleteArrayItems(ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
        arrayList.remove(i);
        }
    }


}
