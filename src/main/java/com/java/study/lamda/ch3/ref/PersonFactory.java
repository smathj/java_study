package com.java.study.lamda.ch3.ref;

@FunctionalInterface
public interface PersonFactory {

    Person create(String name, int age);

}
