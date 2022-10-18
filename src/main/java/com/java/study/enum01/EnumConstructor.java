package com.java.study.enum01;

enum Person2 {
    MAN, WOMAN;

    private Person2() {
        System.out.println("Person constructor called");
    }


    @Override
    public String toString() {
        return "I am a dog person";
    }
}


public class EnumConstructor {
    public static void main(String[] args) {
        System.out.println(Person2.MAN);
        System.out.println(Person2.WOMAN);
    }
}
