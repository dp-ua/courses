package com.epam.math.factorial;

import java.math.BigInteger;

public class Factorial {
    private final long start;
    private final long end;

    public Factorial(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public Factorial(long end) {
        this.start = 1;
        this.end = end;
    }

    public static void main(String[] args) {
        final Factorial f = new Factorial(100);
        final long start = System.nanoTime();
//        final BigInteger factorial = f.factorial(1000000); // 100s 5mln       // 200 sec 10mln
        final BigInteger factorial = f.calc(); // 100s 5mln       // 200 sec 10mln
        final long finish = System.nanoTime();
        System.out.println("string len: " + factorial.toString().length());
        System.out.println("time: " + (finish - start) / 1000000000 + "sec");
    }

    public BigInteger calc() {
        System.out.printf("Calcing factorial {%d,%d}!\n", start, end);
        final BigInteger calc = calc(start, end);
        System.out.printf("Result factorial {%d,%d}!=%s\n", start, end, calc.toString());
        return calc;
    }

    private BigInteger calc(long start, long end) {
        if (checkInput(start, end)) return BigInteger.valueOf(1);

        BigInteger result = BigInteger.valueOf(1);
        for (long i = start; i <= end; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private boolean checkInput(long start, long end) {
        if (start >= end)
            throw new IllegalArgumentException(String.format("start{%d} must be less then end{%d}", start, end));
        if (end == 0) return true;
        if (end < 0)
            throw new IllegalArgumentException(String.format("end{%d} can't be negative", end));
        return false;
    }
}
