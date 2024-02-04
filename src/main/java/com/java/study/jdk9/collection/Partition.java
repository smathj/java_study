package com.java.study.jdk9.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partition {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(new Human("홍길동1", 1),
                new Human("홍길동2", 2),
                new Human("홍길동3", 3),
                new Human("홍길동4", 4),
                new Human("홍길동5", 5),
                new Human("홍길동6", 6),
                new Human("홍길동7", 7),
                new Human("홍길동8", 8));


        Map<Boolean, List<Human>> collectList = humanList.stream().collect(Collectors.partitioningBy(human -> human.getAge() >= 5));

        // 5살 이상
        List<Human> fiveUpList = collectList.get(true);

        System.out.println("5살 이상");
        for (Human human : fiveUpList) {
            System.out.println(human);
        }

        System.out.println();

        // 5살 미만
        List<Human> fiveDownList = collectList.get(false);

        System.out.println("5살 미만");
        for (Human human : fiveDownList) {
            System.out.println(human);
        }

    }
}
