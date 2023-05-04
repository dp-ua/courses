package com.epam.codewars.isogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IsogramTest {
    Isogram isogram;

    @Before
    public void setUp() {
        isogram = new Isogram();
    }

    @Test
    public void FixedTests() {
        assertEquals("true", isogram.isIsogram("Dermatoglyphics"));
        assertEquals("true", isogram.isIsogram("isogram"));
        assertEquals("false", isogram.isIsogram("moose"));
        assertEquals("false", isogram.isIsogram("isIsogram"));
        assertEquals("false", isogram.isIsogram("aba"));
        assertEquals("false", isogram.isIsogram("moOse"));
        assertEquals("true", isogram.isIsogram("thumbscrewjapingly"));
        assertEquals("true", isogram.isIsogram(""));
    }

}