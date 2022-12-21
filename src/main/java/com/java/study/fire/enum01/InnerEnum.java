package com.java.study.fire.enum01;


class Customer {
    // * 클래스 내에 정의된 열거형 Gender
    enum Gender {
        MALE, FEMALE
    }

    private String name;
    private Gender gen;


    public Customer(String name, String gen) {
        this.name = name;
        if (gen.equals("man")) {
            this.gen = Gender.MALE;
        } else {
            this.gen = Gender.FEMALE;
        }
    }

    @Override
    public String toString() {
        if (gen == Gender.MALE) {
            return "Thank you, Mr " + name;
        } else {
            return "Thank you, Mrs " + name;
        }
    }
}

public class InnerEnum {
    public static void main(String[] args) {
        Customer cus1 = new Customer("Brown", "man");
        Customer cus2 = new Customer("Susan Hill", "woman");

        System.out.println(cus1);
        System.out.println(cus2);

    }
}
