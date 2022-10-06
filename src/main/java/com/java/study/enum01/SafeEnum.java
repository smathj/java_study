package com.java.study.enum01;

enum Animal {
    DOG,
    CAT
} 

enum Person {
    MAN,
    WOMAN
}


public class SafeEnum {
    public static void main(String[] args) {
        who(Person.MAN);
//        who(Animal.DOG);  // 컴파일 에러
    }
    
    public static void who(Person man) {
        Person m = man;
        System.out.println("m = " + m);
        System.out.println("m.name() = " + m.name());
        System.out.println("m.toString() = " + m.toString());
        switch(man) {
            case MAN :
                System.out.println("남자 입니다");
                break;
            case WOMAN :
                System.out.println("여자 입니다");
                break;
        }
    } 
}
