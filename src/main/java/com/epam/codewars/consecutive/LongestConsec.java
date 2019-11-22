package com.epam.codewars.consecutive;

import java.util.Arrays;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        String result = "";
        if (isNotOkInput(strarr, k)) return result;
        for (int i = 0; i <= strarr.length-k ; i++) {
            String tempResult = String.join("", Arrays.copyOfRange(strarr, i, i + k));
            if (tempResult.length()>result.length()) result=tempResult;
        }
        return result;
    }

    private static boolean isNotOkInput(String[] strarr, int k) {
        if (strarr == null) return true;

        int n = strarr.length;
        if (k <= 0) return true;
        if (n == 0) return true;
        if (k > n) return true;

        return false;
    }
}
