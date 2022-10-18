package com.java.study.relection.ex01;

public class Book {

    private String title;
    private int price;

    Book() { }
    Book(String title) {
        this.title = title;
    }
    Book(int price) {
        this.price = price;
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
