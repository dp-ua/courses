package com.epam.math.factorial;

import lombok.SneakyThrows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    private final int THREADS = 8;
    private final List<BigInteger> results = new ArrayList<>();

    @SneakyThrows
    public static void main(String[] args) {
        long n = 1000000;
        final long start = System.nanoTime();
        final Runner runner = new Runner();
        final Map<Long, Long> threadsRange = runner.getThreadsRange(n);

//        parallelStreamVariant(runner, threadsRange);
        myThreadsVariant(runner, threadsRange);

        while (threadsRange.size() != runner.results.size()) {
            Thread.sleep(1000);
        }

        final BigInteger result = runner.results.stream().reduce(BigInteger::multiply).get();
        final long finish = System.nanoTime();
        System.out.println("\nResult:" + result.toString());
        System.out.println("string len: " + result.toString().length());
        System.out.println("time: " + (finish - start) / 1000000000 + "sec");

    }

    private static void parallelStreamVariant(Runner runner, Map<Long, Long> threadsRange) {
        threadsRange.entrySet().parallelStream().forEach(entry ->{
            runner.results.add(new Factorial(entry.getKey(),entry.getValue()).calc());
        });
    }

    private static void myThreadsVariant(Runner runner, Map<Long, Long> threadsRange) throws InterruptedException {
        for (Map.Entry<Long, Long> entry : threadsRange.entrySet()) {
            final Thread thread = new Thread(new ThreadFactorial(entry.getKey(), entry.getValue(), runner.results));
            thread.start();
        }
    }

    private Map<Long, Long> getThreadsRange(long number) {
        if (number < THREADS + 1)
            throw new IllegalArgumentException("number{" + number + "} can't be less then [THREADS+1]: " + (THREADS + 1));
        Map<Long, Long> result = new HashMap<>();
        final long increment = (number + 1) / THREADS;
        for (long i = 0; i < number; i = i + increment) {
            if ((i + 1 + increment) >= number) {
                result.put(i + 1, number);
                break;
            }
            result.put(i + 1, i + increment);
        }
        return result;
    }


}
