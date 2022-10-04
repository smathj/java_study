package com.java.study.collection;

import java.util.Comparator;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.age;
    }

    // 기본 오름차순
    @Override
    public int compareTo(Person p) {
        // 파라미터가 더 작으면 양의 정수 반환
        // 파라미터가 더크면 음의 정수 반환
        // 같으면 0을 반환
        System.out.println("======================================================");
        System.out.println("this.age = " + this.age);
        System.out.println("p.age = " + p.age);

//        System.out.println("this.age - p.age :" + (this.age - p.age));
        return this.age - p.age;    // * 오름 차순 (즉, 파라미터야 너가 더 큰위치해라)

//        System.out.println("p.age - this.age :" + (p.age - this.age));
//        return p.age - this.age;  // * 내림 차순
    }
}

// * 추가
class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.age - p1.age; // p2.age - p1.age > 0 이라 생각하고, p2가 더크다 라고 생각하면 내림차순
    }
}


public class ComparablePerson {
    public static void main(String[] args) {
//        TreeSet<Person> tree = new TreeSet<>();
        TreeSet<Person> tree = new TreeSet<>(new PersonComparator());
        tree.add(new Person("YOON", 37));
        tree.add(new Person("HONG", 53));
        tree.add(new Person("PARK", 22));

        for (Person p : tree) {
            System.out.println(p);
        }
    }
}
