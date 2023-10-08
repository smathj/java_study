package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamEx2_10 {

    public static void main(String[] args) {

        List<Book2_10> list = Arrays.asList(new Book2_10("나", 1000, 3),
                new Book2_10("가", 2000, 1),
                new Book2_10("라", 3000, 4),
                new Book2_10("마", 1000, 5),
                new Book2_10("다", 4000, 2)
        );

        IntSummaryStatistics intSummaryStatistics = list.stream()
                .mapToInt((b) -> b.getPrice())
                .summaryStatistics();

        double average = intSummaryStatistics.getAverage();
        int max = intSummaryStatistics.getMax();
        int min = intSummaryStatistics.getMin();
        long count = intSummaryStatistics.getCount();
        long sum = intSummaryStatistics.getSum();

        System.out.println("average = " + average);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);


    }
}
class Book2_10 {

    String name;
    Integer price;
    Integer seq;

    public Book2_10(String name, Integer price, Integer seq) {
        this.name = name;
        this.price = price;
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Book2_10{" +
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
