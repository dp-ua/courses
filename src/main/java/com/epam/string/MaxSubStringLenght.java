package com.epam.string;

import java.util.AbstractMap;

public class MaxSubStringLenght {
    public int getMaxSubStringLen(String input) {
        return getMaxSubString(input).length();
    }

    public static void main(String[] args) {
        final MaxSubStringLenght maxSubStringLenght = new MaxSubStringLenght();
        System.out.println(maxSubStringLenght.getMaxSubString("aaabbbbbdsasdaas dasddddddasdasaasdasdsd"));
    }

    public String getMaxSubString(String input) {
        AbstractMap.SimpleEntry<String, String> longest = new AbstractMap.SimpleEntry("", "");
        AbstractMap.SimpleEntry<String, String> temp = new AbstractMap.SimpleEntry("", "");

        for (String s : input.split("")) {
            if ("".equals(temp.getKey())) {
                temp = new AbstractMap.SimpleEntry(s, s);
                continue;
            }
            if (s.equals(temp.getKey())) {
                temp.setValue(temp.getValue() + s);
            } else {
                if (longest.getValue().length() < temp.getValue().length()) {
                    longest = temp;
                }
                temp = new AbstractMap.SimpleEntry(s, s);
            }
        }

        return longest.getValue().length() >= temp.getValue().length() ? longest.getValue() : temp.getValue();
    }
}
