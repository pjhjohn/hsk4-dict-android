package com.hsk4dictionary.android.model;

/**
 * Created by pjhjohn on 2015-05-27.
 */
public class Card {
    public String word;
    public String pronunciation;
    public String word_type;
    public String meaning;
    public String created_at;
    public String updated_at;

    public Card(String word, String pronunciation, String word_type, String meaning) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.word_type = word_type;
        this.meaning = meaning;
    }
}
