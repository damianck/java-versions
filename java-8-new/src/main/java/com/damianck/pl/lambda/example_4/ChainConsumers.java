package com.damianck.pl.lambda.example_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Joey", "Monika", "Rachel", "Chandler", "Ross", "Pheobe");

        List<String> result = new ArrayList<>();

        Consumer<String> print = System.out::println;
        Consumer<String> append = result::add;

        names.forEach(print.andThen(append));
        System.out.println();
        result.forEach(print);

    }
}
