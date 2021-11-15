package com.epam.matrix.stack;

import java.util.AbstractMap.SimpleEntry;
import java.util.Stack;

public class ArrayWalker {
    public int[] getAnalyze(int[] input) {
        final int[] result = new int[input.length];
        final Stack<SimpleEntry<Integer, Integer>> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            final SimpleEntry<Integer, Integer> entry = new SimpleEntry<>(input[i], i);
            while (stack.size() > 0) {
                final SimpleEntry<Integer, Integer> peek = stack.peek();
                if (peek.getKey() > entry.getKey()) {
                    result[i] = peek.getValue() - i;
                    stack.push(entry);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.size() == 0) {
                result[i] = 0;
                stack.push(entry);
            }
        }
        return result;
    }
}
