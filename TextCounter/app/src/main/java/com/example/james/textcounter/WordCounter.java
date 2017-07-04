package com.example.james.textcounter;

/**
 * Created by james on 04/07/2017.
 */

public class WordCounter {

    public static int count(String phrase){
        if(phrase == null || phrase.length() == 0){
            return 0;
        }
        return phrase.split(" ").length;
    }
}
