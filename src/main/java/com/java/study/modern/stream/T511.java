package com.java.study.modern.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// filter
public class T511 {

    public static void main(String[] args) {

        // 필터링
        List<User> subList = Arrays.asList(new User("김유섭", 30, true),
                                           new User("구리섭", 31, false),
                                           new User("두레섭", 32, true));


        List<User> aliveSubList = subList.stream()
                .filter(User::isDelYn)
                .collect(Collectors.toList());

        for (User sub : aliveSubList) {
            System.out.println(sub);
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

