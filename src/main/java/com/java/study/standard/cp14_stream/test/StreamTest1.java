package com.java.study.standard.cp14_stream.test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {
    //    public static class Student implements Comparable<Student> {
    public static class Student implements Comparable<Student> {

        String name;
        int ban;
        int totalScore;

        public Student(String name, int ban, int totalScore) {
            this.name = name;
            this.ban = ban;
            this.totalScore = totalScore;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d, %d]", name, ban, totalScore);
        }

        public String getName() {
            return name;
        }

        public int getBan() {
            return ban;
        }

        public int getTotalScore() {
            return totalScore;
        }

        // 총점 내림차순을 기본 정렬로 한다
        @Override
        public int compareTo(Student s) {
            return s.totalScore - this.totalScore;
        }
    }

    public static void main(String[] args) {


        Student[] stuArr = {
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };

        List<Student> stuList = Stream.of(stuArr).collect(Collectors.toList());


        Map<String, Integer> stuNameAndScoreMap = stuList.stream().collect(Collectors.toMap((s -> s.getName()), (s -> s.getTotalScore())));
        System.out.println("stuNameAndScoreMap = " + stuNameAndScoreMap);
        List<Integer> scoreList = stuNameAndScoreMap.values().stream().collect(Collectors.toList());
/*
        int i = 0;
        for (String name : stuNameAndScoreMap.keySet()) {
            System.out.printf("이름 : %s, 점수 : %s \n", name, scoreList.get(i));
            i++;
        }
*/

        // 최대
        Optional<Student> maxOption = stuList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(stu -> stu.getTotalScore())));
        System.out.println(maxOption.get());


        // 최소
        Optional<Student> minOption = stuList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(stu -> stu.getTotalScore())));
        System.out.println(minOption.get());

        


    }


}
