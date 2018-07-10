package com.damianck.pl.stream.example_1;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Predicates {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("One","Two","Three","Four","Five","Six");

        Predicate<String> predicate = x -> x.length() > 3;
        Predicate<String> predicate1 = Predicate.isEqual("Two");
        Predicate<String> predicate2 = Predicate.isEqual("Three");

        stream.filter(predicate1.or(predicate2));


        stream.forEach(System.out::println);

    }
}
