package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx2_6 {

    public static void main(String[] args) {

        List<Book> list = Arrays.asList(new Book("나", 1000, 3),
                new Book("가", 2000, 1),
                new Book("라", 3000, 4),
                new Book("마", 1000, 5),
                new Book("바", 3000, 6),
                new Book("다", 4000, 2)
        );

        // 복습 1
        /*
        list.stream()
                // .sorted(Comparator.comparing(b1 -> b1.getPrice()).reversed())     // 람다식 에러
                .sorted(Comparator.comparing(Book::getPrice).reversed()
//                        .thenComparing(Book::getName).reversed()
                        .thenComparing(Book::getSeq))            // 메서드참조
                .forEach(System.out::println);
*/

        list.stream()
                .sorted((s1,s2) -> s1.getName().compareTo(s2.getName()))        // 이름 오름차순
                .sorted((s1,s2) -> s2.getPrice().compareTo(s1.getPrice()))      // 가격 내림 차순
//                .sorted((s1,s2) -> s1.getSeq().compareTo(s2.getSeq()))        // v1. 시퀀스 오름차순
//                .sorted(Comparator.comparing(Book::getSeq))                   // v2. 시퀀스 오름차순
                .sorted(Comparator.comparing(Book::getSeq).reversed())          // v1. 시퀀스 내림차순
                .forEach(System.out::println);
    }
}

class Book {

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
