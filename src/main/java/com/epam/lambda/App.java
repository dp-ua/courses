package com.epam.lambda;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    private Map<Integer, String> map;
    final int mapLimit = 10000;

    static BiFunction<Integer, Integer, Integer> min = (a, b) -> a < b ? a : b;
    static Function<String, BigInteger> toBigInt = BigInteger::new;

    static BiFunction<String, String, String> sumBigInt = (a, b) ->
            toBigInt.apply(a).add(toBigInt.apply(b)).toString();


    @FunctionalInterface
    public interface Calculate  {
        int method(int x, int y);
    }

    static Calculate difference = (a,b) -> Math.abs(a-b) ;
    static Calculate minimum = (a,b) -> Math.min(a,b) ;

    public static void main(String[] args) {

        Arrays.stream(new int[]{1, 2, 3, 4})
                .map(n -> n * n)
//                .forEach(System.out::println)
                .reduce((a,b) -> a+=b)
                .ifPresent(System.out::println)
        ;
    }


    public App() {
        initMap();
    }


    private String getRandomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }


    private void initMap() {
        map = new HashMap<>();

        for (int i = 0; i < mapLimit; i++) {
            map.put((int) (Math.random() * mapLimit), getRandomString());
        }
    }


}
