package com.java.study.fire.nested.lamda;


// 추상 메서드가 하나인 인터페이스
//interface Printable {
//    void print(String s);
//}

public class Lambda3 {
    public static void main(String[] args) {
        Printable prn = (s) -> { System.out.println(s);};
//         Printable prn = System.out::println;
        prn.print("What is Lambda?");
    }
}
