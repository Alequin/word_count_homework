package com.example.james.textcounter;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by james on 04/07/2017.
 */

public class WordCounterTest {

    @Test
    public void countWords(){
        String words = "oh what a lovely day. oh what a lovely day";
        WordCounter.count(words);
        assertEquals(10, words);
    }

}
