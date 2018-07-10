package com.damianck.pl.stream.example_3;

import java.util.Arrays;
import java.util.List;

public class Reduction {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 10, 10);

        int sum =
                list.stream()
                        .reduce(0, Integer::max);


        System.out.println(sum);
    }
}
