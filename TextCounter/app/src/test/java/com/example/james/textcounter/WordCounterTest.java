package com.example.james.textcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by james on 04/07/2017.
 */

public class WordCounterTest {

    private HashMap<String, Integer> expectedOccurrenceHash;

    @Before
    public void setup(){
        expectedOccurrenceHash = new HashMap<>();
        expectedOccurrenceHash.put("one", 4);
        expectedOccurrenceHash.put("two", 3);
        expectedOccurrenceHash.put("three", 2);
        expectedOccurrenceHash.put("four", 1);
    }

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
        assertEquals(expectedOccurrenceHash.get("one"), WordCounter.getOccurrenceHash(words).get("one"));
        assertEquals(expectedOccurrenceHash.get("two"), WordCounter.getOccurrenceHash(words).get("two"));
        assertEquals(expectedOccurrenceHash.get("three"), WordCounter.getOccurrenceHash(words).get("three"));
        assertEquals(expectedOccurrenceHash.get("four"), WordCounter.getOccurrenceHash(words).get("four"));
    }

    @Test
    public void canCountOccurrenceOfWordsWithExtraCharacters() {
        String words = "one one. two one, two three one' two three four";
        assertEquals(expectedOccurrenceHash.get("one"), WordCounter.getOccurrenceHash(words).get("one"));
        assertEquals(expectedOccurrenceHash.get("two"), WordCounter.getOccurrenceHash(words).get("two"));
        assertEquals(expectedOccurrenceHash.get("three"), WordCounter.getOccurrenceHash(words).get("three"));
        assertEquals(expectedOccurrenceHash.get("four"), WordCounter.getOccurrenceHash(words).get("four"));
    }

    @Test
    public void canCountOccurrenceOfWordsIgnoresCase() {
        String words = "oNe One. Two onE, tWo thREe oNe' tWo tHree fOur";
        assertEquals(expectedOccurrenceHash.get("one"), WordCounter.getOccurrenceHash(words).get("one"));
        assertEquals(expectedOccurrenceHash.get("two"), WordCounter.getOccurrenceHash(words).get("two"));
        assertEquals(expectedOccurrenceHash.get("three"), WordCounter.getOccurrenceHash(words).get("three"));
        assertEquals(expectedOccurrenceHash.get("four"), WordCounter.getOccurrenceHash(words).get("four"));
    }

    @Test
    public void canFormatOccurrenceHashResults(){
        String words = "one one two one two three one two three four";
        String expected = "one: 4, two: 3, three: 2, four: 1";
        HashMap<String, Integer> occurrenceHash = WordCounter.getOccurrenceHash(words);
        assertEquals(expected, WordCounter.formatOccurenceHash(occurrenceHash));
    }
}
