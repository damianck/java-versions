package com.damianck.pl.lambda.example_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
    public static void main(String[] args) {

        Comparator<String> comparator =
                Comparator.comparingInt(String::length);
        //  (o1, o2) -> Integer.compare(o1.length(), o2.length());

        List<String> stars = Arrays.asList("***", "*", "*****", "****", "**", "******");
        Collections.sort(stars, comparator);

        for (String star : stars) {
            System.out.println(star);
        }
    }
}
