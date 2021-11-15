package com.epam.matrix.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayWalkerTest {
    private ArrayWalker walker;

    @Before
    public void setUp() {
        walker = new ArrayWalker();
    }

    @Test
    public void test_Case1() {
        final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, walker.getAnalyze(input));
    }

    @Test
    public void test_Case2() {
        final int[] input = {4, 3, 2, 1};
        assertArrayEquals(new int[]{0, 0, 0, 0}, walker.getAnalyze(input));
    }

    @Test
    public void test_Case3() {
        final int[] input = {13, 12, 15, 11, 9, 12, 16};
        assertArrayEquals(new int[]{2, 1, 4, 2, 1, 1, 0}, walker.getAnalyze(input));
    }

}