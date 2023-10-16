package com.java.study.standard.cp14_stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx_6 {

    static class Student {
        String name;
        boolean isMale; // 상별
        int hak;        // 학년
        int ban;        // 반
        int score;

        public Student(String name, boolean isMale, int hak, int ban, int score) {
            this.name = name;
            this.isMale = isMale;
            this.hak = hak;
            this.ban = ban;
            this.score = score;
        }

        public String getName() {
            return name;
        }
        public boolean isMale() {
            return isMale;
        }
        public int getHak() {
            return hak;
        }
        public int getBan() {
            return ban;
        }
        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score);
        }

        // groupingBy() 에서 사용
        enum Level {
            HIGH, MID, LOW  // 성적을 상,중,하 세 단계로 분류
        }
    }

    public static void main(String[] args) {


        Student[] stuArr = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200),
        };

        // 학년 그륩별 반 그룹별
        Map<Integer, Map<Integer, List<Student>>> hakMap = Stream.of(stuArr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak, Collectors.groupingBy(Student::getBan)
                        )
                );

//        System.out.println(hakMap.keySet());

        for (Integer key : hakMap.keySet()) {
//            System.out.println(key + " 학년별 반 Map");
            Map<Integer, List<Student>> banMap = hakMap.get(key);
            for (Integer ban : banMap.keySet()) {
                List<Student> studentList = banMap.get(ban);
//                System.out.println(key + "학년 " + ban + "반 학생리스트");
//                System.out.println("studentList = " + studentList);
                for (Student student : studentList) {
                    System.out.println(student);
                }

            }


        }

        Map<Integer, Map<Integer, Student>> dataMap = Stream.of(stuArr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak, Collectors.groupingBy(
                                                    Student::getBan,
                                                    Collectors.collectingAndThen(
                                                            Collectors.maxBy(
                                                                    Comparator.comparingInt(Student::getScore)),
                                                                    Optional::get
                                                            )
                                                 )
                        )
                );


    }
}
