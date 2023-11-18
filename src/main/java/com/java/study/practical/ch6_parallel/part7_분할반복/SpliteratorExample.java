package com.java.study.practical.ch6_parallel.part7_분할반복;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {

    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        // 순차 처리
        Spliterator<HelloPerson> spliterator = personList.spliterator();

        spliterator.forEachRemaining((person) -> {
            System.out.printf("안녕~~ %s\n", person);
        });
    }
}
