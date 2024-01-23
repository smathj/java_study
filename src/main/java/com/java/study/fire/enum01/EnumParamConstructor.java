package com.java.study.fire.enum01;

enum Person3 {
    MAN(29), WOMAN(25);

    private int age;
    private Person3(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "I am " + age + " years old";
    }

}


public class EnumParamConstructor {
    public static void main(String[] args) {
        Person3 man = Person3.MAN;
        System.out.println(man);
        Person3 woman = Person3.WOMAN;
        System.out.println(woman);
    }
}
