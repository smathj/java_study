package com.java.study.jdk9.collection;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DownStreamCollector2 {

    public static void main(String[] args) {


        List<Human> humanList = Arrays.asList(new Human("홍길동1", 1),
                new Human("홍길동2", 2),
                new Human("홍길동3", 3),
                new Human("홍길동4", 4),
                new Human("홍길동5", 5),
                new Human("홍길동6", 6),
                new Human("홍길동7", 7),
                new Human("홍길동8", 8));

        Map<Boolean, Long> collectMap = humanList
                .stream()
                .collect(Collectors.groupingBy(human -> human.getAge() % 2 == 0, Collectors.counting()));

        // Collectors.groupingBy(human -> human.getAge() % 2 == 0)
        // 첫번째 파라미터만 넣으면 디폴트로 리스트로 반환한다


        // 짝수
        Long evenCount = collectMap.get(true);
        System.out.println("짝수 = " + evenCount);




        System.out.println();
        

        // 홀수
        Long oddCount = collectMap.get(false);
        System.out.println("홀수 = " + oddCount);

    }


}
