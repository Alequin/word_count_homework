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

    public static String formatOccurrenceHash(HashMap<String, Integer> occurrenceHash) {
        String[] segments = buildSegmentsArray(occurrenceHash);

        segments = sortOccurrenceSegmentsArray(segments);

        String results = "";
        final int length = segments.length;
        for(int j=0; j < length; j++){
            results += segments[j];
            if(j < length-1){
                results += ", ";
            }
        }

        return results;
    }

    private static String[] buildSegmentsArray(HashMap<String, Integer> occurrenceHash){
        final String[] keys = occurrenceHash.keySet().toArray(new String[1]);
        final Integer[] values = occurrenceHash.values().toArray(new Integer[1]);
        String[] segments = new String[keys.length];

        final int length = segments.length;

        for(int j=0; j < length; j++){
            final String val = Integer.toString(values[j]);
            segments[j] = keys[j] + ": " + val;
        }
        return segments;
    }

    private static String[] sortOccurrenceSegmentsArray(String[] segments){
        final int length = segments.length;

        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int j=1; j<length; j++){
                final int segmentVal1 = getSegmentValue(segments[j-1]);
                final int segmentVal2 = getSegmentValue(segments[j]);
                if(segmentVal1 < segmentVal2){
                    swapIndeces(segments, j-1, j);
                    sorted = false;
                }
            }
        }
        return segments;
    }

    private static int getSegmentValue(String segment){
        final int valueIndex = segment.length()-1;
        final char charValue = segment.charAt(valueIndex);
        String value = Character.toString(charValue);
        return Integer.parseInt(value);
    }

    private static void swapIndeces(String[] array, int index1, int index2){
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
