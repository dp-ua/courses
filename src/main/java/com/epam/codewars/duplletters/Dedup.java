package com.epam.codewars.duplletters;

import java.util.Stack;

public class Dedup {
    public String dedup(String input) {
        Stack<String> stack = new Stack<>();
        String deleted = "";
        for (String c : input.split("")) {
            if (stack.isEmpty() && !c.equals(deleted)) {
                stack.push(c);
                deleted = "";
            } else if (deleted.equals(c)) {
                //skip
            } else if (stack.peek().equals(c)) {
                deleted = stack.pop();
            } else {
                stack.push(c);
                deleted = "";
            }
        }
        return String.join("", stack);
    }
}
