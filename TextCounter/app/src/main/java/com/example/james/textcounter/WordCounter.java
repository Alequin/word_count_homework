package com.example.james.textcounter;

import android.util.Log;

import java.util.HashMap;

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

    public static HashMap<String, Integer> getOccurrenceHash(String phrase){
        HashMap<String, Integer> occurrenceHash = new HashMap<>();
        final String[] words = phrase.split(" ");
        for(String word : words){
            word = word.toLowerCase();
            word = removeNonLetterFromEnd(word);
            int count = occurrenceHash.get(word) != null ? (occurrenceHash.get(word) + 1) : 1;
            occurrenceHash.put(word, count);
        }
        return occurrenceHash;
    }



    private static String removeNonLetterFromEnd(String string){
        int indexToKeep = string.length();
        char[] letters = string.toCharArray();
        for(int j=string.length()-1; j >= 0; j--){
            char letter = letters[j];
            if(letter < 'a' || letter > 'z'){
                indexToKeep = j;
            }else {
                break;
            }
        }
        return string.substring(0, indexToKeep);
    }
}
