package com.damianck.pl.library.features;

public class Book implements PricedObject {

    String title;
    double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
