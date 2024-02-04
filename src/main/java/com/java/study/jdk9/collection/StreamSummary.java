package com.java.study.jdk9.collection;


import java.util.*;
import java.util.stream.Collectors;

public class StreamSummary {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(new Human("홍길동1", 1, "1반"),
                new Human("홍길동2", 2, "1반"),
                new Human("홍길동3", 3, "1반"),
                new Human("홍길동4", 4, "1반"),
                new Human("홍길동5", 5, "2반"),
                new Human("홍길동6", 6, "2반"),
                new Human("홍길동7", 7, "3반"),
                new Human("홍길동8", 8, "3반"));

        DoubleSummaryStatistics ageStat = humanList.stream().collect(Collectors.summarizingDouble(Human::getAge));

        double average = ageStat.getAverage();

        double max = ageStat.getMax();

        double min = ageStat.getMin();

        long count = ageStat.getCount();

        double sum = ageStat.getSum();


        System.out.println("average = " + average);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("count = " + count);
        System.out.println("sum = " + sum);





    }


}
