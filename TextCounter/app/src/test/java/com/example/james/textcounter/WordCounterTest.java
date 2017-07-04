package com.example.james.textcounter;

import org.junit.Test;
import org.junit.Before;

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


}
