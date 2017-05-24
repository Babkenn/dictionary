package com.example.babken.learnenglish.date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.babken.learnenglish.date.EnglishWordContract.EnglishWordEntry;
/**
 * Created by Babken on 14.05.2017.
 */

public class EnglishWordsReaderDbHelper extends SQLiteOpenHelper {
    EnglishWordContract ghg=new EnglishWordContract();
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EnglishWords.db";




    public EnglishWordsReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + EnglishWordEntry.TABLE_NAME + " (" +
                        EnglishWordEntry._ID + " INTEGER PRIMARY KEY," +
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO + TEXT_TYPE + COMMA_SEP +
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_TWO_TRANSLATE +TEXT_TYPE +COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_ONE_TRANSLATE + TEXT_TYPE +COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE + TEXT_TYPE + COMMA_SEP +
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_THREE_TRANSLATE +TEXT_TYPE +COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_FOUR + TEXT_TYPE + COMMA_SEP +
                        EnglishWordEntry.COLUMN_NAME_FILMS_CATEGORY_FOUR +TEXT_TYPE +COMMA_SEP +
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_FIVE +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME__CATEGORY_FIVE_TRANLSATE +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME1 +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME2 +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME3 +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME4 +TEXT_TYPE+COMMA_SEP+
                        EnglishWordEntry.COLUMN_NAME_CATEGORY_NAME5 +TEXT_TYPE+
                        " )";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
