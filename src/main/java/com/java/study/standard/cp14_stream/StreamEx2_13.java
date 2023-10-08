package com.java.study.standard.cp14_stream;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2_13 {

    public static void main(String[] args) {

        Student2_13[] stuArr = {
            new Student2_13("이자바", 3, 300),
            new Student2_13("김자바", 1, 200),
            new Student2_13("안자바", 2, 100),
            new Student2_13("박자바", 2, 150),
            new Student2_13("소자바", 1, 200),
            new Student2_13("나자바", 3, 290),
            new Student2_13("김자바", 3, 180)
        };


        Stream<Student2_13> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student2_13::getBan)  // 반별 정렬
                     .thenComparing(Comparator.naturalOrder())      // 기본 정렬
                     )
                     .forEach(System.out::println);                 // 스트림 소모


        stuStream = Stream.of(stuArr);                              // 스트림 생성
        IntStream stuScoreStream = stuStream.mapToInt((s) -> s.getTotalScore());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        long count = stat.getCount();
        long sum = stat.getSum();
        double average = stat.getAverage();
        int max = stat.getMax();
        int min = stat.getMin();

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
//        System.out.println("average = " + average);
        System.out.println("average = " + decimalFormat.format(average));       // 소수점 두자리
        System.out.println("max = " + max);
        System.out.println("min = " + min);


    }
}

class Student2_13 implements Comparable<Student2_13> {

    String name;
    int ban;
    int totalScore;

    public Student2_13(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }
    public int getBan() {
        return ban;
    }
    public int getTotalScore() {
        return totalScore;
    }

    // 총점 내림차순을 기본 정렬로 한다
    @Override
    public int compareTo(Student2_13 s) {
        return s.totalScore - this.totalScore;
    }
}
