package com.epam.math;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        final Palindrome p = new Palindrome();

        Assert.assertEquals(true, p.isPalindrome("а роза упала на лапу Азора"));
        Assert.assertEquals(true, p.isPalindrome("топот"));
        Assert.assertEquals(false, p.isPalindrome("топddот"));
        Assert.assertEquals(false, p.isPalindrome(1232));
        Assert.assertEquals(true, p.isPalindrome(123321));
        Assert.assertEquals(true, p.isPalindrome(121232121));
        Assert.assertEquals(true, p.isPalindrome(101));
        Assert.assertEquals(true, p.isPalindrome(1001));
        Assert.assertEquals(true, p.isPalindrome(10101));
        Assert.assertEquals(true, p.isPalindrome(10001));
        Assert.assertEquals(false, p.isPalindrome(101001));
        Assert.assertEquals(false, p.isPalindrome(1008801));
        Assert.assertEquals(true, p.isPalindrome(10088001));
        Assert.assertEquals(true, p.isPalindrome(12345678987654321L));

    }
}