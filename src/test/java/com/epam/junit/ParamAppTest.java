package com.epam.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class ParamAppTest {
    private String numA;
    private String numB;
    private String expected;
    private App app = new App();

    public ParamAppTest(String numA, String numB, String expected) {
        this.numA = numA;
        this.numB = numB;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0","0","0"},
                {"1","0","1"},
                {"0","-1","-1"},
                {"-10","-100","-110"},
                {"-1111111111111111111111111111111","1111111111111111111111111111111","0"},
                {"99999999999999999999999999999999","1","100000000000000000000000000000000"},
                {"100000000000000000000000000000000","-1","99999999999999999999999999999999"}

        });
    }

    @Test
    public void sumBigNumbers() {
        assertThat(app.sumBigNumbers(numA,numB),is(expected));
    }
}