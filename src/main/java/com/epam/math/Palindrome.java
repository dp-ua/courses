package com.epam.math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public static int recursion(int n) {
        if (n < 10) {
            return n;
        }
        else {
            System.out.print(n % 10 + " ");
            return recursion(n / 10);
        }
    }
    public static void main(String[] args) {
        System.out.println(recursion(123));
    }

    private boolean isEquals(Stack<Object> rightOrder, Queue<Object> reverseOrder) {
        while (!reverseOrder.isEmpty()) {
            final Object one = reverseOrder.poll();
            final Object two = rightOrder.pop();
            if (!one.equals(two)) return false;
        }
        return true;
    }

    public boolean isPalindrome(String text) {
        Stack<Object> rightOrder = new Stack<>();
        Queue<Object> reverseOrder = new LinkedList<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (c != 32) {
                reverseOrder.add(c);
                rightOrder.push(c);
            }
        }
        return isEquals(rightOrder, reverseOrder);
    }


    public boolean isPalindrome(long n) {
        Stack<Object> rightOrder = new Stack<>();
        Queue<Object> reverseOrder = new LinkedList<>();
        while (n > 0) {
            byte i = (byte) (n % 10);
            reverseOrder.add(i);
            rightOrder.push(i);
            n = n / 10;
        }
        return isEquals(rightOrder, reverseOrder);
    }

}
