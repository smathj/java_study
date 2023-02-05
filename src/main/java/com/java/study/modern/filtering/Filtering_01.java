package com.java.study.modern.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering_01 {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                books.add(new Book("제목" + i, (i * 1000), true));
            } else {
                books.add(new Book("제목" + i, (i * 1000), false));
            }
        }

        List<Book> collect = books.stream()
                .filter(Book::isSell)
                .collect(Collectors.toList());

        for (Book filterBook : collect) {
            System.out.println("filterBook = " + filterBook);
        }
    }

    public static class Book {
        String name;
        int price;

        boolean isSell;

        public Book(String name, int price, boolean isSell) {
            this.name = name;
            this.price = price;
            this.isSell = isSell;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public boolean isSell() {
            return isSell;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", isSell=" + isSell +
                    '}';
        }
    }

}
