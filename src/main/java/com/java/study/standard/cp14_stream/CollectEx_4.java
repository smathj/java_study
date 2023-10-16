package com.java.study.standard.cp14_stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class CollectEx_4 {

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

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student::getBan));                          // toList() 생략가능    (import static java.util.stream.Collectors.*;)


        for (List<Student> ban : stuByBan.values()) {
            for (Student s : ban) {
                System.out.println(s);
            }
            System.out.println();
        }


        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        // key가 enum
        Map<Student.Level, List<Student>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy((s -> {
                            if (s.getScore() >= 200) return Student.Level.HIGH;
                            else if (s.getScore() >= 100) return Student.Level.MID;
                            else return Student.Level.LOW;
                            }))
                );                                                          // toList() 생략가능


        TreeSet<Student.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student.Level key : keySet) {
            System.out.println("[" + key + "]");

            for (Student s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student.Level.HIGH;
                    else if (s.getScore() >= 100) return Student.Level.MID;
                    else return Student.Level.LOW;
                }, counting()));

        for (Student.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();


        System.out.printf("%n4. 다중그룹화 + 통계(학년별, 반별)%n");
        Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = Stream.of(stuArr)    // 학년, 반
                .collect(groupingBy(Student::getHak, groupingBy(Student::getBan)));

        // ? 교재 변수이름 좀 이상함
        for (Map<Integer, List<Student>> hak : stuByHakAndBan.values()) {   // key :반, value: 학생들
            for (List<Student> ban : hak.values()) {    // 1반, 2반, ... roop
                for (Student s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(
                                groupingBy(Student::getHak,             // 학년별 그륩
                                        groupingBy(Student::getBan,     // 반별 그륩인데
                                                collectingAndThen(      // 반별 1등    Optional을 꺼내기위해서 collectingAndThen 메서드 사용
                                                        maxBy(comparingInt(Student::getScore)), Optional::get
                                                )
                                        )
                                )
                        );

        for (Map<Integer, Student> ban : topStuByHakAndBan.values()) {
            for (Student s : ban.values()) {
                System.out.println(s);
            }
        }


        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                                mapping(s -> {
                                    if (s.getScore() >= 200) return Student.Level.HIGH;
                                    else if (s.getScore() >= 100) return Student.Level.MID;
                                    else return Student.Level.LOW;
                                }, toSet())
                        )
                );

        Set<String> keySet2 = stuByScoreGroup.keySet();
        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }

    }
}
