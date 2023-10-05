package com.java.study.modern.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// distinct
public class T512 {

    public static void main(String[] args) {

        // 필터링
        List<User> subList = Arrays.asList(new User("김유섭", 30, false),
                                           new User("구리섭", 31, false),
                                           new User("두레섭", 32, true),
                                           new User("유기섭", 32, true));


        List<Integer> collect = subList.stream()
                .map((sub) -> {
                    return sub.getAge();
                })
                .distinct()
                .collect(Collectors.toList());

        for (Integer age : collect) {
            System.out.println("age = " + age);
        }


    }


    static class User {

        private String name;
        private int age;
        private boolean delYn;

        public User(String name, int age, boolean delYn) {
            this.name = name;
            this.age = age;
            this.delYn = delYn;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isDelYn() {
            return delYn;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", delYn=" + delYn +
                    '}';
        }
    }

}

