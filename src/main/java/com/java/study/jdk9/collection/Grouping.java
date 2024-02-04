package com.java.study.jdk9.collection;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(new Human("홍길동1", 1),
                new Human("홍길동2", 2),
                new Human("홍길동3", 3),
                new Human("홍길동4", 4),
                new Human("홍길동5", 5),
                new Human("홍길동6", 6),
                new Human("홍길동7", 7),
                new Human("홍길동8", 8));

        Map<Boolean, List<Human>> collectMap = humanList.stream().collect(Collectors.groupingBy(human -> human.getAge() % 2 == 0));


        // 짝수
        List<Human> evenMap = collectMap.get(true);

        // 홀수
        List<Human> oddMap = collectMap.get(false);

        System.out.println("짝수 맵");
        for (Human human : evenMap) {
            System.out.println(human);
        }

        System.out.println();

        System.out.println("홀수 맵");
        for (Human human : oddMap) {
            System.out.println(human);
        }



    }


}
