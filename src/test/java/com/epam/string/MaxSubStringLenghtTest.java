package com.epam.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubStringLenghtTest {
    private MaxSubStringLenght maxSubstr;

    @Before
    public void setUp(){
        maxSubstr = new MaxSubStringLenght();
    }
    @Test
    public void getMaxSubStringLen() {
    }

    @Test
    public void getMaxSubString() {
        assertEquals("", maxSubstr.getMaxSubString(""));
        assertEquals("aaaaaaaaaa", maxSubstr.getMaxSubString("aaaaaaaaaa"));
        assertEquals("a", maxSubstr.getMaxSubString("abcdefjh"));
        assertEquals("aa", maxSubstr.getMaxSubString("aabcdefjs"));
        assertEquals("aa", maxSubstr.getMaxSubString("aabcddefjs"));
        assertEquals("ddd", maxSubstr.getMaxSubString("aabcdddefjs"));
    }
}