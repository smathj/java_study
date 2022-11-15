package com.java.study.playground;


public class MyTest {
    public static void main(String[] args) {


        Book firstBook = new Book
                .Builder("자바책", 1000)
                .build();

        // 옵셔널이였던 writer는 기본값으로 초기화된다, 따라서 정적 멤버 클래스의
        // writer 변수를 빈문자열로 초기화 시켜두거나, null 임을 명확히 인지하자
        System.out.println("firstBook = " + firstBook);

        System.out.println();


        Book secondBook = new Book
                .Builder("자바책", 1000)
                .writer("")
                .build();


        System.out.println("secondBook = " + secondBook);

    }

}
