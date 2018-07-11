package com.damianck.pl.stream.example_5;

import com.damianck.pl.stream.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExp {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        CollectorsExp.class.getResourceAsStream("../../../../../../resources/people.txt")));

                Stream<String> stream = reader.lines();

        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                people.add(p);
                return p;
            })
                    .forEach(System.out::println);


        } catch (IOException ioException) {
            System.out.println(ioException);
        }

        Optional<Person> opt =
                people.stream().filter(p -> p.getAge() >= 20)
                        .min(Comparator.comparing(Person::getAge));
        System.out.println(opt);

        Optional<Person> opt2 =
                people.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);

        Map<Integer, String> map =
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                //Collectors.counting()  => Long
                                                //Collectors.mapping(Person::getName,Collectors.toList()) => String
                                                //Collectors.toCollection(TreeSet::new) => Set<String>
                                                Collectors.joining(", ")
                                        )
                                )
                        );
        System.out.println(map);

    }
}
