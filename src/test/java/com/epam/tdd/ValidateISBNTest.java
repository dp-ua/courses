package com.epam.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {
    @Test
    public void checkAValid_10_ISBN() {
        ValidateISBN validateISBN=new ValidateISBN();
        boolean result = validateISBN.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validateISBN.checkISBN("0140177396");
        assertTrue("second value",result);
    }

    @Test
    public void checkAValid_13_DigitsISBN() {
        ValidateISBN validateISBN=new ValidateISBN();
        boolean result = validateISBN.checkISBN("9789661104210");
        assertTrue("first value", result);
        result = validateISBN.checkISBN("9781853260087");
        assertTrue("second value", result);
    }

    @Test
    public void checkAnInvalid_13_ISBN() {
        ValidateISBN validateISBN=new ValidateISBN();
        boolean result = validateISBN.checkISBN("9781853260085");
        assertFalse(result);
    }


    @Test public void _10_ISBNnumbersEndingInAnXAreValid(){
        ValidateISBN validateISBN=new ValidateISBN();
        boolean result = validateISBN.checkISBN("012000030X");
        assertTrue( result);
    }
    @Test
    public void checkAnInvalid_10_ISBN() {
        ValidateISBN validateISBN=new ValidateISBN();
        boolean result = validateISBN.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigestISBNAreNotAllowed() {
        ValidateISBN validateISBN=new ValidateISBN();
        validateISBN.checkISBN("123456789");

    }

    @Test(expected = NumberFormatException.class)
    public void onlyDigitsInISBNAreAllowed() {
        ValidateISBN validateISBN=new ValidateISBN();
        validateISBN.checkISBN("helloworld");
    }



}