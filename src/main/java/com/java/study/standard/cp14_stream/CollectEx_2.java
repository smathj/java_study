package com.java.study.standard.cp14_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx_2 {
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

        // 학생 이름만 뽑아서 List<String>에 저장
//        Stream<Student> stream = Arrays.stream(stuArr);

        List<String> names = Stream.of(stuArr)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("names = " + names);

        // 스트림을 배열로 반환
        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);

        for (Student s : stuArr2) {
            System.out.println(s);
        }

        // 스트림을 Map<String, Student>로 변환, 학생이름이 Key
        Map<String, Student> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s -> s.getName(), s -> s));

        for (String name : stuMap.keySet()) {
            System.out.println(name + "-" + stuMap.get(name));
        }

        // count, sum(marry) <== reducing
        long count = Stream.of(stuArr).collect(Collectors.counting());
        long totalScore = Stream.of(stuArr).collect(Collectors.summingInt((s) -> s.getTotalScore()));                  // collect 인자 1

        System.out.println("count = " + count);
        System.out.println("totalScore = " + totalScore);

        // reducing
        totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));   // collect 인자 3
        System.out.println("totalScore = " + totalScore);



        // Max
        Optional<Student> topStudent = Stream.of(stuArr)
                .collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println("topStudent = " + topStudent.get());


        // SummaryStatistics
        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(Collectors.summarizingInt(Student::getTotalScore));
        System.out.println("stat = " + stat);

        // joining
        String stuNames = Stream.of(stuArr)
                .map(Student::getName)
                .collect(Collectors.joining(",", "{", "}"));

        System.out.println("stuNames = " + stuNames);


    }




    static class Student implements Comparable<Student> {

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

}
