package com.java.study.jdk9.collection;


import java.util.*;
import java.util.stream.Collectors;

public class DownStreamCollector5 {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(
                new Human("홍길동1", 1, "1반"),
                new Human("홍길동22", 1, "1반"),
                new Human("홍길동333", 2, "1반"),
                new Human("홍길동4444", 3, "1반"),

                new Human("홍길동5", 2, "2반"),
                new Human("홍길동66", 5, "2반"),

                new Human("홍길동7", 3, "3반"),
                new Human("홍길동88", 8, "3반"));




        // v2
        Map<String, Optional<String>> collectMap = humanList.stream()
                .collect(Collectors.groupingBy(human -> human.getGrade(),
                        Collectors.mapping(Human::getName, Collectors.maxBy(Comparator.comparing(String::length)))));



        // 브레이크 포인트 걸고 펼쳐보기
        System.out.println("collectMap = " + collectMap);

    }


}
