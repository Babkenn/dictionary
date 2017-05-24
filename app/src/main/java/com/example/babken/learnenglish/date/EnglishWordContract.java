package com.example.babken.learnenglish.date;

import android.provider.BaseColumns;

/**
 * Created by Babken on 14.05.2017.
 */

public class EnglishWordContract {

    EnglishWordContract(){};

    public static abstract class EnglishWordEntry implements BaseColumns{

        public static final String TABLE_NAME = "EnglishWords";

        public static final String COLUMN_NAME_CATEGORY_ONE = "categoryone_words";
        public static final String COLUMN_NAME_CATEGORY_ONE_TRANSLATE = "categoryone_words_translate";

        public static final String COLUMN_NAME_CATEGORY_TWO =  "categorytwo_words";
        public static final String COLUMN_NAME_CATEGORY_TWO_TRANSLATE = "categorytwo_words_translate";


        public static final String COLUMN_NAME_CATEGORY_THREE = "categorythree_words";
        public static final String COLUMN_NAME_CATEGORY_THREE_TRANSLATE = "categorythree_words_translate";

        public static final String COLUMN_NAME_CATEGORY_FOUR = "categoryfour_words";
        public static final String COLUMN_NAME_FILMS_CATEGORY_FOUR = "categoryfour_words_translate";

        public static final String COLUMN_NAME_CATEGORY_FIVE = "categoryfive_words";
        public static final String COLUMN_NAME__CATEGORY_FIVE_TRANLSATE = "categoryfive_words_translate";


        public static final String COLUMN_NAME_CATEGORY_NAME1 = "category_namesOne";
        public static final String COLUMN_NAME_CATEGORY_NAME2 = "category_namesTwo";
        public static final String COLUMN_NAME_CATEGORY_NAME3 = "category_namesThree";
        public static final String COLUMN_NAME_CATEGORY_NAME4 = "category_namesFour";
        public static final String COLUMN_NAME_CATEGORY_NAME5 = "category_namesFive";
    }
}
