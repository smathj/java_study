package com.java.study.master.ch5;

import java.util.Arrays;
import java.util.Comparator;

public class Sample2 {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Ken", 100),
                new Student("Shin", 60),
                new Student("Kim", 80)
        };

        Comparator<Student> comparator = new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getScore(), o1.getScore());   // 객체 내림차순
            }
        };

        Arrays.sort(students, comparator);
        System.out.println(Arrays.toString(students));

    }
}
