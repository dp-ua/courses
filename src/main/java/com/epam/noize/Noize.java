package com.epam.noize;

import java.util.HashMap;

public class Noize {
    public static void main(String[] args) {

        HashMap<String, String> input = new HashMap<>();
        input.put("text", "text");
        input.put("text\n", "text");
        input.put("text text34", "text");
        input.put("text\n test", "text");
        input.put("text ", "text");
        input.put("text@dp_ua", "text@dp_ua");
        input.entrySet().forEach(e -> {
            System.out.println(e.getValue().equals(getCommand(e.getKey())));
        });
        System.out.println("/text".substring(1));
    }


    public static String getText(String text) {
        return null;
    }

    public static String getCommand(String text) {
        String[] split = text.split(" |\n");
        return split[0];
    }
}
