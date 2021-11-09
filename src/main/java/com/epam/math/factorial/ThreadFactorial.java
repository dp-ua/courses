package com.epam.math.factorial;

import java.math.BigInteger;
import java.util.List;

public class ThreadFactorial implements Runnable {
    private final List<BigInteger> resultCollector;
    private final long start, end;

    public ThreadFactorial(long end, List<BigInteger> resultCollector) {
        this(1, end, resultCollector);
    }

    public ThreadFactorial(long start, long end, List<BigInteger> resultCollector) {
        this.resultCollector = resultCollector;
        this.end = end;
        this.start = start;
    }

    @Override
    public void run() {
        System.out.printf("Thread {%d,%d} started\n", start, end);
        final Factorial f = new Factorial(start, end);
        final BigInteger calc = f.calc();
        System.out.printf("Thread {%d,%d} finished\n", start, end);
        resultCollector.add(calc);
    }
}
