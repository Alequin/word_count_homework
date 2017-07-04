package com.example.james.textcounter;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by james on 04/07/2017.
 */

public class WordCounterTest {

    @Test
    public void canCountWords(){
        String words = "oh what a lovely day. oh what a lovely day";
        assertEquals(10, WordCounter.count(words));
    }

    @Test
    public void canCountWordsWhenInputIsNull(){
        assertEquals(0, WordCounter.count(null));
    }

    @Test
    public void canCountWordsWhenLengthZero(){
        assertEquals(0, WordCounter.count(""));
    }

    @Test
    public void canCountOccurrenceOfWords() {
        String words = "one one two one two three one two three four";
        //loved that and when dog said hi
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("one", 4);
        expected.put("two", 3);
        expected.put("three", 2);
        expected.put("four", 1);
        assertEquals(expected.get("one"), WordCounter.getOccurrenceHash(words).get("one"));
        assertEquals(expected.get("two"), WordCounter.getOccurrenceHash(words).get("two"));
        assertEquals(expected.get("three"), WordCounter.getOccurrenceHash(words).get("three"));
        assertEquals(expected.get("four"), WordCounter.getOccurrenceHash(words).get("four"));
    }

    @Test
    public void canCountOccurrenceOfWordsWithExtraCharacters() {
        String words = "one one. two one, two three one' two three four";
        //loved that and when dog said hi
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("one", 4);
        expected.put("two", 3);
        expected.put("three", 2);
        expected.put("four", 1);
        assertEquals(expected.get("one"), WordCounter.getOccurrenceHash(words).get("one"));
        assertEquals(expected.get("two"), WordCounter.getOccurrenceHash(words).get("two"));
        assertEquals(expected.get("three"), WordCounter.getOccurrenceHash(words).get("three"));
        assertEquals(expected.get("four"), WordCounter.getOccurrenceHash(words).get("four"));
    }
}
