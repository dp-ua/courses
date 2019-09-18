package com.epam.codewars.cesar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CeaserCipherTest {
    private CeaserCipher ceaserCipher = new CeaserCipher();

    @Test
    public void decode() {
        String result = "I should have known that you would have a perfect answer for me!!!";
        List<String> input = Arrays.asList(
                "ijJ tipvme ibw",
                "f lopxo uibu z",
                "pv xpvme ibwf ",
                "b qfsgfdu botx",
                "fs gps nf!!!");
        assertEquals(result,ceaserCipher.decode(input));
    }

    @Test
    public void encode() {
        String input = "O CAPTAIN! my Captain! our fearful trip is done;";
        int shift = 1;
        List<String> result = Arrays.asList("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;");
        assertEquals(result,ceaserCipher.encode(input,shift));
    }


    @Test
    public void shiftChar() {
        assertTrue('p' == ceaserCipher.shiftChar('o',1));
        assertTrue('a' == ceaserCipher.shiftChar('z',1));
    }
}