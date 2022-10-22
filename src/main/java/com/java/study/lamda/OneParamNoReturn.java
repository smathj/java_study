package com.java.study.lamda;

interface Printable {
    void print(String s);   // 매개변수 하나, 반환형 void
}


public class OneParamNoReturn {
    public static void main(String[] args) {
        Printable p;
        
        p = (String s) -> { System.out.println(s); };   // 줄임 없는 표현
        p.print("람다 첫번째");

        p = (String s) -> System.out.println(s);   // 중괄호 생략
        p.print("람다 두번째");
        
        p = (s) -> System.out.println(s);   // 매개변수 타입 생략
        p.print("람다 세번째");
        
        p = s -> System.out.println(s);   // 매개변수 소괄호 생략
        p.print("람다 네번째");
        
        
        
        
        
        
        
    }
}
