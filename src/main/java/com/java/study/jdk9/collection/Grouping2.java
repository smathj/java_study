package com.java.study.jdk9.collection;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Grouping2 {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(new Human("홍길동1", 1, "1반"),
                new Human("홍길동2", 2, "1반"),
                new Human("홍길동3", 3, "1반"),
                new Human("홍길동4", 4, "1반"),
                new Human("홍길동5", 5, "2반"),
                new Human("홍길동6", 6, "2반"),
                new Human("홍길동7", 7, "3반"),
                new Human("홍길동8", 8, "3반"));

        Map<String, List<Human>> banList = humanList.stream()
                .collect(Collectors.groupingBy(human -> human.getGrade()));



        Set<String> banSet = banList.keySet();
        for (String ban : banSet) {
            List<Human> eachBanList = banList.get(ban);
            System.out.println();
            System.out.println("ban = " + ban);
            for (Human human : eachBanList) {
                System.out.println(human);
            }
        }



    }


}
