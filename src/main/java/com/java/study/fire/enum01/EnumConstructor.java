package com.java.study.fire.enum01;

enum Person2 {
    MAN, WOMAN;

    private Person2() {
        System.out.println("Person constructor called");
    }


//    @Override
//    public String toString() {
//        return "I am a dog person";
//    }


}


public class EnumConstructor {
    public static void main(String[] args) {
        Person2 man = Person2.MAN;
        System.out.println("man = " + man);
        System.out.println("man.name() = " + man.name());
        Person2 woman = Person2.WOMAN;
        System.out.println("woman = " + woman);
        System.out.println("woman.name() = " + woman.name());
    }
}
