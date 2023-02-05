package com.java.study.modern.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering_02 {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                books.add(new Book("짝수", 2000, true));
            } else {
                books.add(new Book("홀수", 3000, false));
            }
        }

        List<String> collect = books.stream()
                .filter(Book::isSell)
                .map(book -> book.getName())
                .distinct()
                .collect(Collectors.toList());

        for (String bookName : collect) {
            System.out.println("bookName = " + bookName);
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
