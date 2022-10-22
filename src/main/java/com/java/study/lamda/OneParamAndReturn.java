package com.java.study.lamda;


interface HowLong {
    int len(String s);  // 값을 반환하는 메서드
} 

public class OneParamAndReturn {
    public static void main(String[] args) {
        HowLong hl = (s) -> s.length(); // return 키워드 생략
        System.out.println(hl.len("안녕하세요"));
    }
}
