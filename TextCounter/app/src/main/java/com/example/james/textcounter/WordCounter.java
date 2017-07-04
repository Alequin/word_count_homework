package com.example.james.textcounter;

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
            Integer currentCount = occurrenceHash.get(word);
            if(currentCount != null){
                currentCount++;
                occurrenceHash.put(word, currentCount);
            }else{
                occurrenceHash.put(word, 1);
            }
        }
        return occurrenceHash;
    }
}
