package com.epam.codewars.cesar;

import java.util.ArrayList;
import java.util.List;

public class CeaserCipher {
    public String decode(List<String> textParts) {

        return null;
    }

    private String generatePrefix(String text, int shift) {
        char firstLetter = text.substring(0, 1).toLowerCase().charAt(0);
        return String.valueOf(firstLetter) + String.valueOf(shiftChar(firstLetter, shift));
    }

    private boolean isWorkCharRange(char ch) {
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }

    private boolean isGoodPrefix(String[] prefix) {
        char ch0 = prefix[0].charAt(0);
        char ch1 = prefix[1].charAt(0);
        if (isWorkCharRange(ch0))
            if (isWorkCharRange(ch1)) {
                if ((ch0 - 90 <= 0) && (ch1 - 90 <= 0)) return true;
                else if ((ch0 - 122 <= 0) && (ch1 - 122 <= 0)) return true;
                else return false;

            } else return false;
        return true;
    }

    private int getShift(String encodedText) {
        if (encodedText.length() < 3) throw new IllegalArgumentException("Encoded test length must be more than 2");
        String[] prefix = encodedText.substring(0, 1).split("");

        return 0;
    }

    private List<String> splitString(String text) {
        List<String> result = new ArrayList<>();
        String work = new String(text);
        int partLen = text.length() % 5 == 0 ? text.length() / 5 : text.length() / 4;
        while (work.length() > 0) {
            if (work.length() <= partLen) {
                result.add(work.substring(0));
                work = new String();
            } else {
                result.add(work.substring(0, partLen));
                work = work.substring(partLen);
            }
        }
        return result;
    }

    public List<String> encode(String text, int shift) {
        StringBuffer result = new StringBuffer();
        for (char ch : text.toCharArray()) {
            result.append(String.valueOf(shiftChar(ch, shift)));
        }

        return splitString(generatePrefix(text, shift) + result.toString());
    }


    protected Character shiftChar(char ch, int shift) {
        int result = (int) ch;
        if (ch >= 65 && ch <= 90) {
            result += shift % 25;
            result = result > 90 ? result - 25 : result;
        } else if (ch >= 97 && ch <= 122) {
            result += shift % 25;
            result = result > 122 ? result - 26 : result;
        }
        return (char) result;
    }


}
