package com.java.study.enum01;

enum Person3 {
    MAN(29), WOMAN(25);

    int age;
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
        System.out.println(Person3.MAN);
        System.out.println(Person3.WOMAN);
    }
}
