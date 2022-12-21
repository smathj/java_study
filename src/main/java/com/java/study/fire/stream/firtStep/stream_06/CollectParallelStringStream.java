package com.java.study.fire.stream.firtStep.stream_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectParallelStringStream {
    public static void main(String[] args) {
        String[] words = {"Hello", "Box", "Robot", "Toy"};
        Stream<String> ss = Arrays.stream(words);

        List<String> ls = ss.parallel()
                .filter(s -> s.length() < 5)
                .collect(() -> new ArrayList<>(), (c, s) -> c.add(s), (list1, list2) -> list1.addAll(list2));
        /*
        1. 다수의 저장소 생성
        2. 각 저장소마다 데이터 추가
        3. 각저장소를 단 하나의 저장소에 모아서 리턴
         */
        System.out.println(ls);

    }
}
