package com.java.study.jdk9.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Human {

    private String name;
    private int age;
    private String grade;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
