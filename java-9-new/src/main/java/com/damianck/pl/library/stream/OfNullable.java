package com.damianck.pl.library.stream;

import com.damianck.pl.library.Book;

import java.util.stream.Stream;

import static com.damianck.pl.library.Book.getBook;

public class OfNullable {

    public static void main(String... args) {

        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(getBook()).count();

        System.out.printf("zero: %d, one: %d", zero, one);

        // Before ofNullable
        Book book = getPossiblyNull(true);
        Stream<String> authors =
                book == null ? Stream.empty() : book.authors.stream();
        authors.forEach(System.out::println);

        // With ofNullable
        Stream.ofNullable(getPossiblyNull(false))
                .flatMap(b -> b.authors.stream())
                .forEach(System.out::println);
    }

    private static Book getPossiblyNull(boolean isNull) {
        return isNull ? null : getBook();
    }


}
