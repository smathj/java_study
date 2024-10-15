package com.java.study.lamda.ch3.likefinal;

import com.java.study.lamda.ch3.ref.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Test1 {

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }



    public static int sumAllAges(List<Person> people) {
        int sum = 0;
        for (Person person : people) {
            sum += person.getAge();
        }
        return sum;
    }

    public final static Integer forEach(List<Person> people, Function<Integer, Integer> function) {
        Integer result = null;
        for (Person person : people) {
            result = function.apply(person.getAge());
        }
        System.out.println("result = " + result);
        return result;
    }

    /**
     * 나쁜 방법
     */
    public static void badExample() {
        Function<Integer, Integer> sum = new Function<>() {
            // 누적합
            private Integer sum = 0;

            @Override
            public Integer apply(Integer amount) {
                sum += amount;
                System.out.println("amount = " + amount);
                return sum;
            }
        };

        List<Person> list = new ArrayList<>();
        list.add(new Person("홍길동", 10));
        list.add(new Person("길동", 20));
        forEach(list, sum);
    }




    public static void main(String[] args) {
        badExample();
    }
}
