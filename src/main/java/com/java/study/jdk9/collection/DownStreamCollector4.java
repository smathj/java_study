package com.java.study.jdk9.collection;


import java.util.*;
import java.util.stream.Collectors;

public class DownStreamCollector4 {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(
                new Human("홍길동1", 1, "1반"),
                new Human("홍길동2", 1, "1반"),
                new Human("홍길동3", 2, "1반"),
                new Human("홍길동4", 3, "1반"),

                new Human("홍길동5", 2, "2반"),
                new Human("홍길동6", 5, "2반"),

                new Human("홍길동7", 3, "3반"),
                new Human("홍길동8", 8, "3반"));

        // v1
        Map<String, Optional<Human>> maxAgeByBan = humanList.stream()
                .collect(Collectors.groupingBy(human -> human.getGrade(), Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge())));    // 오름차순



        // v2
//        Map<String, Optional<Human>> maxAgeByBan = humanList.stream()
//                .collect(Collectors.groupingBy(human -> human.getGrade(), Collectors.maxBy(Comparator.comparing(Human::getAge))));

        // 브레이크 포인트 걸고 펼쳐보기
        System.out.println("maxAgeByBan = " + maxAgeByBan);


    }


}
