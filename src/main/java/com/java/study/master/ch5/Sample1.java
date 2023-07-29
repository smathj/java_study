package com.java.study.master.ch5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample1 {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Jung", 100));
        studentList.add(new Student("Song", 70));
        studentList.add(new Student("Tommy", 80));

        System.out.println("studentList = " + studentList);

        //
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getScore(), o2.getScore());
            }
        });

        System.out.println("studentList = " + studentList);
    }
}
