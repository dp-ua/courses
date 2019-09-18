package com.epam.junit;


import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    private Function<String, BigInteger> toBigInt = BigInteger::new;
    private BiFunction<String, String, String> sumBigInt = (a, b) ->  toBigInt.apply(a).add(toBigInt.apply(b)).toString();

    public String sumBigNumbers(String a, String b) {
        return sumBigInt.apply(a,b);
    }
}
