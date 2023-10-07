package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx2_8 {

    public static void main(String[] args) {

        List<Book> list = Arrays.asList(new Book("나", 1000, 3),
                new Book("가", 2000, 1),
                new Book("라", 3000, 4),
                new Book("마", 1000, 5),
                new Book("다", 4000, 2)
        );

        list.stream()
                .sorted(Comparator.comparing(Book::getPrice)    // 가격 오름차순
                        .thenComparing(Comparator.comparing(Book::getSeq).reversed())  // 순번 내림차순
                        .thenComparing(Comparator.comparing(Book::getName))  // 이름 오름차순
                )

                .forEach(System.out::println);


    }

//    static class Book implements Comparable<Book>{
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

//        @Override
//        public int compareTo(Book o) {
//            return o.seq - this.seq;
//        }
    }

}

