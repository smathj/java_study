package com.java.study.standard.cp14_stream;

import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectEx_1 {

    public static void main(String[] args) {

        List<Book> bookList = Arrays.asList(
                new Book("이것이 자바다", 1000, 4),
                new Book("자바의 정석", 5000, 1),
                new Book("자바 프로그래밍", 2000, 5),
                new Book("코어 자바스크립트", 4000, 2),
                new Book("JPA", 3000, 3)
        );

        // v1. List
        List<String> titleList = bookList.stream()
                .map(Book::getName)
                .collect(toList());

        System.out.println("titleList = " + titleList);


        // v2. Set
        Set<String> titleSet = bookList.stream()
                .map(Book::getName)
                .collect(toSet());

        System.out.println("titleSet = " + titleSet);


        // v3. Map
        Map<Integer, Book> bookMap = bookList.stream()
                .collect(toMap(b -> b.getSeq(), b -> b));

        System.out.println("bookMap = " + bookMap);


        // v4. 커스텀
        ArrayList<String> arrayList = bookList.stream()
                .map(Book::getName)
                .collect(toCollection(ArrayList::new));

        System.out.println("arrayList = " + arrayList);



        // v5. 특정 배열
        Book[] bookArr = bookList.toArray(Book[]::new);

        System.out.println("bookArr = " + Arrays.toString(bookArr));



        // v6. Object[]
        Object[] objArr = bookList.toArray();

        System.out.println("objArr = " + Arrays.toString(objArr));


    }


    static class Book {

        String name;
        Integer price;
        Integer seq;

        public Book(String name, Integer price, Integer seq) {
            this.name = name;
            this.price = price;
            this.seq = seq;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", seq=" + seq +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getSeq() {
            return seq;
        }

        public void setSeq(Integer seq) {
            this.seq = seq;
        }
    }

}
