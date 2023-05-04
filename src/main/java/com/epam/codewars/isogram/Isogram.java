package com.epam.codewars.isogram;

public class Isogram {
    public String isIsogram(String input) {
        return String.valueOf(
                input.toLowerCase().chars().distinct().count() == input.length());
    }
}
