package com.java.study.standard.cp11_compare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String[] args) {
        System.out.println();

        List<Human> people = new ArrayList<>();

        people.add(new Human(10, "10살"));
        people.add(new Human(30, "30살"));
        people.add(new Human(20, "20살"));

        System.out.println("people = " + people);
        lineLog();

        // 오름 차순 정렬
        // v1.
        people.sort((o1, o2) -> {
            if(o1.getAge() > o2.getAge()) {
                return  1;
            } else if(o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                return 0;
            }
            // v2.
//            return o1.getAge().compareTo(o2.getAge());    // (정렬은 내부 기본 셋팅을 따른다)
        });

        System.out.println("[나이-오름차순] people = " + people);
        lineLog();


        // 내림 차순 정렬
        people.sort((o1, o2) -> {
            // v1.
            if(o1.getAge() > o2.getAge()) {
                return  1 * -1;
            } else if(o1.getAge() < o2.getAge()) {
                return -1* -1;
            } else {
                return 0;
            }
            // v2.
//            return o2.getAge().compareTo(o1.getAge());     // (정렬은 내부 기본 셋팅을 따른다)
        });

        System.out.println("[나이-내림차순] people = " + people);
        lineLog();


        // (정렬은 내부 기본 셋팅을 따른다)
        List<Human> collect = people.stream()
                .sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("[람다-나이-오름차순] people = " + collect);
        lineLog();


        // (정렬은 내부 기본 셋팅을 따른다)
        List<Human> collect2 = people.stream()
                .sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge()))
                .collect(Collectors.toList());
        System.out.println("[람다-나이-내림차순] people = " + collect2);


    }

    public static void lineLog() {
        System.out.println("=======================================================================================================================================");
    }
}

class Human {

    private Integer age;
    private String username;

    public Integer getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public Human(Integer age, String username) {
        this.age = age;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}

