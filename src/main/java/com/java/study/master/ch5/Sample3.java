package com.java.study.master.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample3 {

    public static void main(String[] args) {


        Student ken = new Student("Ken", 100);
        Student shin = new Student("Shin", 60);
        Student kim = new Student("Kim", 80);
        Student kim2 = new Student("Park", 80);

        List<Student> studentList = new ArrayList<>();

        studentList.add(ken);
        studentList.add(shin);
        studentList.add(kim);
        studentList.add(kim2);

        // sort

        // 오름 차순 정렬
        studentList.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getScore() - o2.getScore())
                .forEach(System.out::println);


        // 내림 차순 정렬
        studentList.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .forEach(System.out::println);


        // collect
        List<Student> collect = studentList.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        // join
        List<String> stringList = Arrays.asList("A", "B", "C");
        String joinStr = stringList.stream()
                .collect(Collectors.joining(","));
        System.out.println("joinStr = " + joinStr);

        // group
        Map<Integer, List<Student>> groupMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getScore));

        System.out.println("groupMap = " + groupMap);


        // IntStream
        IntStream.range(0 ,5).forEach(System.out::println);


    }
}
