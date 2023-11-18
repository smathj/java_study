package com.java.study.practical.ch6_parallel.part7_분할반복;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloPerson {

    private String firstName;
    private String lastName;
    private String country;

    public static List<HelloPerson> getSampleDate() {

        List<HelloPerson> person = new ArrayList<>();

        person.add(new HelloPerson("윤기", "정", "대한민국"));
        person.add(new HelloPerson("해리", "장", "미국"));
        person.add(new HelloPerson("해윤", "장", "중국"));
        person.add(new HelloPerson("애리", "노", "일본"));
        person.add(new HelloPerson("크롱", "장", "남극"));

        return person;
    }
}
