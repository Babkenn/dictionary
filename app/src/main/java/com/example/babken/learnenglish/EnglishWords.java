package com.example.babken.learnenglish;

/**
 * Created by Babken on 14.05.2017.
 */

public class EnglishWords {
    String word;
    String translation;

    public EnglishWords(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {

        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
