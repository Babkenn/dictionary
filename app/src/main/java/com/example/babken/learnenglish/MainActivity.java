package com.example.babken.learnenglish;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.babken.learnenglish.date.EnglishWordContract;
import com.example.babken.learnenglish.date.EnglishWordsReaderDbHelper;
import com.example.babken.learnenglish.date.EnglishWordContract.EnglishWordEntry;
import com.example.babken.learnenglish.readClassActivities.ReadCategoryTwoActivity;
import com.example.babken.learnenglish.readClassActivities.ReadCategoryFourActivity;
import com.example.babken.learnenglish.readClassActivities.ReadCategoryOneActivity;
import com.example.babken.learnenglish.readClassActivities.ReadCategoryFiveActivity;
import com.example.babken.learnenglish.readClassActivities.ReadCategoryThreeActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    TextView textViewHome,textViewWork,textViewStreet,textViewFilms,textViewOther;
    Button btnAdd;
    Button changeButton;

    //
    EditText editText,editText2,changeEdit;
    EnglishWordsReaderDbHelper dbHelper;
    SQLiteDatabase db;
    ImageButton updatebtn1,updatebtn2,updatebtn3,updatebtn4,updatebtn5;

//lists
    public static ArrayList<EnglishWords> englishCategoryOneWordses;
    public  static ArrayList<EnglishWords> englishCategoryTwoWordses;
    public  static ArrayList<EnglishWords> englishCategoryThreeWordses;
    public  static ArrayList<EnglishWords> englishCategoryFourWordses;
    public  static ArrayList<EnglishWords> englishCategoryFiveWordses;

    public static  ArrayList<String> categoryFirstNameList;
    public static  ArrayList<String> categorySecondNameList;
    public static  ArrayList<String> categoryThirdNameList;
    public static  ArrayList<String> categoryFourthNameList;
    public static  ArrayList<String> categoryFifthNameList;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);;
        editText=(EditText)findViewById(R.id.edit_text_id);
        editText2=(EditText)findViewById(R.id.edit_text_id2);
        //buttons
        btnAdd=(Button)findViewById(R.id.add_btn);
        //textViews
        textViewHome=(TextView)findViewById(R.id.textViewHome);
        textViewWork=(TextView)findViewById(R.id.textViewWork);
        textViewStreet=(TextView)findViewById(R.id.textViewStreet);
        textViewFilms=(TextView)findViewById(R.id.textViewFilms);
        textViewOther=(TextView)findViewById(R.id.textViewOther);

        changeEdit=(EditText)findViewById(R.id.change_edit_1);
        changeButton=(Button) findViewById(R.id.change_button_1);

        englishCategoryOneWordses = new ArrayList<EnglishWords>();
        englishCategoryTwoWordses =new ArrayList<EnglishWords>();
        englishCategoryThreeWordses =new ArrayList<>();
        englishCategoryFourWordses =new ArrayList<>();
        englishCategoryFiveWordses =new ArrayList<>();


        categoryFirstNameList=new ArrayList<>();
        categorySecondNameList=new ArrayList<>();
        categoryThirdNameList=new ArrayList<>();
        categoryFourthNameList=new ArrayList<>();
        categoryFifthNameList=new ArrayList<>();

        //imagebuttons
        updatebtn1=(ImageButton)findViewById(R.id.update1);
        updatebtn2=(ImageButton)findViewById(R.id.update2);
        updatebtn3=(ImageButton)findViewById(R.id.update3);
        updatebtn4=(ImageButton)findViewById(R.id.update4);
        updatebtn5=(ImageButton)findViewById(R.id.update5);

        dbHelper=new EnglishWordsReaderDbHelper(this);


        db = dbHelper.getWritableDatabase();


        Read();
        Log.i(categoryFirstNameList.size()+"","aaaaaaaaaaaaaaa");
        if(categoryFirstNameList.size()!=0) {
            textViewHome.setText(categoryFirstNameList.get(0));
        }
        if(categorySecondNameList.size()!=0) {
            textViewWork.setText(categorySecondNameList.get(0));
        }
        if(categoryThirdNameList.size()!=0) {
            textViewStreet.setText(categoryThirdNameList.get(0));
        }
        if(categoryFourthNameList.size()!=0) {
            textViewFilms.setText(categoryFourthNameList.get(0));
        }
        if(categoryFifthNameList.size()!=0) {
            textViewOther.setText(categoryFifthNameList.get(0));
        }





        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });

        //textViews click action
        textViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadCategoryOneActivity.class);
                startActivity(intent);
            }
        });
        textViewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadCategoryTwoActivity.class);
                startActivity(intent);
            }
        });
        textViewFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadCategoryFourActivity.class);
                startActivity(intent);
            }
        });
        textViewStreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ReadCategoryThreeActivity.class);
                startActivity(intent);

            }
        });
        textViewOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadCategoryFiveActivity.class);
                startActivity(intent);
            }
        });


        updatebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEdit.setVisibility(View.VISIBLE);
                changeButton.setVisibility(View.VISIBLE);

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ContentValues values = new ContentValues();
                        values.put(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME1,changeEdit.getText().toString());
                        final String[] whereArgs = { textViewHome.getText().toString() };

                        if(categoryFirstNameList.size()==0){
                            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, values);
                        }
                        else {
                            db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME1+"=?",whereArgs);
                        }

                        Log.i("sdddddddddddddddd","AAAAAAAAAAAAAAAAAAAAAAA");

                        changeEdit.setVisibility(View.GONE);
                        changeButton.setVisibility(View.GONE);
                        textViewHome.setText(changeEdit.getText());
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(changeButton.getWindowToken(), 0);
                        categoryFirstNameList.add(changeEdit.getText().toString());
                        changeEdit.setText("");

                    }
                });
            }
        });

        updatebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEdit.setVisibility(View.VISIBLE);
                changeButton.setVisibility(View.VISIBLE);

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ContentValues values = new ContentValues();
                        values.put(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME2,changeEdit.getText().toString());
                        final String[] whereArgs = { Long.toString(1) };


                        if(categorySecondNameList.size()==0){
                            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, values);
                        }
                        else {
                            db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordEntry._ID + "=?", whereArgs);
                        }


                        changeEdit.setVisibility(View.GONE);
                        changeButton.setVisibility(View.GONE);
                        textViewWork.setText(changeEdit.getText());
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(changeButton.getWindowToken(), 0);
                        categorySecondNameList.add(changeEdit.getText().toString());

                    }
                });
            }
        });

        updatebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEdit.setVisibility(View.VISIBLE);
                changeButton.setVisibility(View.VISIBLE);

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ContentValues values = new ContentValues();
                        values.put(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME3,changeEdit.getText().toString());
                        final String[] whereArgs = { Long.toString(1) };


                        if(categoryThirdNameList.size()==0){
                            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, values);
                        }
                        else {
                            db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordEntry._ID + "=?", whereArgs);
                        }


                        changeEdit.setVisibility(View.GONE);
                        changeButton.setVisibility(View.GONE);
                        textViewStreet.setText(changeEdit.getText());
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(changeButton.getWindowToken(), 0);
                        categoryThirdNameList.add(changeEdit.getText().toString());

                    }
                });
            }
        });



updatebtn4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        changeEdit.setVisibility(View.VISIBLE);
        changeButton.setVisibility(View.VISIBLE);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ContentValues values = new ContentValues();
                values.put(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME4,changeEdit.getText().toString());
                final String[] whereArgs = { Long.toString(1) };


                if(categoryFourthNameList.size()==0){
                    long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, values);
                }
                else {
                    db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordEntry._ID + "=?", whereArgs);
                }


                changeEdit.setVisibility(View.GONE);
                changeButton.setVisibility(View.GONE);
                textViewFilms.setText(changeEdit.getText());
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(changeButton.getWindowToken(), 0);
                categoryFourthNameList.add(changeEdit.getText().toString());

            }
        });
    }
});

        updatebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEdit.setVisibility(View.VISIBLE);
                changeButton.setVisibility(View.VISIBLE);

                changeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ContentValues values = new ContentValues();
                        values.put(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME5,changeEdit.getText().toString());
                        final String[] whereArgs = { Long.toString(1) };


                        if(categoryFifthNameList.size()==0){
                            long rowID = db.insert(EnglishWordContract.EnglishWordEntry.TABLE_NAME, null, values);
                        }
                        else {
                            db.update(EnglishWordContract.EnglishWordEntry.TABLE_NAME, values, EnglishWordEntry._ID + "=?", whereArgs);
                        }


                        changeEdit.setVisibility(View.GONE);
                        changeButton.setVisibility(View.GONE);
                        textViewOther.setText(changeEdit.getText());
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(changeButton.getWindowToken(), 0);
                        categoryFifthNameList.add(changeEdit.getText().toString());

                    }
                });
            }
        });


        changeEdit.setOnKeyListener(new View.OnKeyListener() {
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

    }
    public void Read() {
        Cursor c = db.query(EnglishWordEntry.TABLE_NAME, null, null, null, null, null, null);

        if (c.moveToFirst()) {
            // определяем номера столбцов по имени в выборке

            int nameColIndex = c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO);
            int translateNameColIndex = c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO_TRANSLATE);
            int nameHomeColIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE);
            int translateHomeIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE_TRANSLATE);
            int nameStreetIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE);
            int translateStreetIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE_TRANSLATE);
            int nameFilmColIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_FOUR);
            int translateFilmColIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_FILMS_CATEGORY_FOUR);
            int nameOtherColIndes=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_FIVE);
            int  translateOtherColIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME__CATEGORY_FIVE_TRANLSATE);

            int firstCategoryIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME1);
            int secondCategoryIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME2);
            int thirdCategoryIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME3);
            int fourthCategoryIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME4);
            int fifthCategoryIndex=c.getColumnIndex(EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME5);

            do {
                if(c.getString(nameColIndex)!=null&&c.getString(translateNameColIndex)!=null){
                 englishCategoryOneWordses.add(new EnglishWords(c.getString(nameColIndex),c.getString(translateNameColIndex)));
                }
                if(c.getString(nameHomeColIndex)!=null&&c.getString(translateHomeIndex)!=null) {
                    englishCategoryTwoWordses.add(new EnglishWords(c.getString(nameHomeColIndex), c.getString(translateHomeIndex)));
                }
                if(c.getString(nameStreetIndex)!=null&&c.getString(translateStreetIndex)!=null) {
                    englishCategoryThreeWordses.add(new EnglishWords(c.getString(nameStreetIndex),c.getString(translateStreetIndex)));
                }
                if(c.getString(nameFilmColIndex)!=null&&c.getString(translateFilmColIndex)!=null) {
                    englishCategoryFourWordses.add(new EnglishWords(c.getString(nameFilmColIndex),c.getString(translateFilmColIndex)));
                }
                if(c.getString(nameOtherColIndes)!=null&&c.getString(translateOtherColIndex)!=null) {
                    englishCategoryFiveWordses.add(new EnglishWords(c.getString(nameOtherColIndes),c.getString(translateOtherColIndex)));
                }



                if(c.getString(firstCategoryIndex)!=null) {
                    categoryFirstNameList.add(c.getString(firstCategoryIndex));
                    Log.i("AAAAAAAAAAAAAAAA","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                }
                if(c.getString(secondCategoryIndex)!=null) {
                    categorySecondNameList.add(c.getString(secondCategoryIndex));
                }
                if(c.getString(thirdCategoryIndex)!=null) {
                    categoryThirdNameList.add(c.getString(thirdCategoryIndex));
                }
                if(c.getString(fourthCategoryIndex)!=null) {
                    categoryFourthNameList.add(c.getString(fourthCategoryIndex));
                }
                if(c.getString(fifthCategoryIndex)!=null) {
                    categoryFifthNameList.add(c.getString(fifthCategoryIndex));
                }
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.exit(0);
        return super.onOptionsItemSelected(item);
    }
}
/*
        <TextView
            android:background="@color/colorBlackLight"
            android:textColor="@color/White"
            android:layout_weight="4"
            android:id="@+id/textViewHome"
            android:layout_height="0dp"
            android:textSize="40sp"
            android:text="@string/home"
            android:layout_width="match_parent"
            />
*/