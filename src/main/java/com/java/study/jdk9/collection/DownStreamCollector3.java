package com.java.study.jdk9.collection;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DownStreamCollector3 {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(
                new Human("홍길동1", 1, "1반"),
                new Human("홍길동2", 1, "1반"),
                new Human("홍길동3", 1, "1반"),
                new Human("홍길동4", 1, "1반"),

                new Human("홍길동5", 2, "2반"),
                new Human("홍길동6", 2, "2반"),

                new Human("홍길동7", 3, "3반"),
                new Human("홍길동8", 3, "3반"));

        Map<String, Integer> banMap = humanList.stream()
                .collect(Collectors.groupingBy(human -> human.getGrade(), Collectors.summingInt(Human::getAge)));


        for (String ban : banMap.keySet()) {
            Integer banHumanCount = banMap.get(ban);

            System.out.printf("%s의 학생수=%s \n", ban, banHumanCount);


        }






    }


}
