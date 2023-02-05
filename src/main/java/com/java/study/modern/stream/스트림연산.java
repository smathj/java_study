package com.java.study.modern.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 스트림연산 {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            books.add(new Book("제목" + i, (i * 1000)));
        }

        // v1. 메서드 참조
/*
        List<String> bookNameList = books.stream()
                .filter(book -> book.getPrice() > 4000)
                .map(Book::getName)
                .limit(3)
                .collect(Collectors.toList());
*/


        // v2. 람다
/*
        List<String> bookNameList = books.stream()      // 리스트에서 스트림 얻기
                .filter(book -> book.getPrice() > 4000) // 중간 연산
                .map(book -> book.getName())            // 중간 연산
                .limit(3)                       // 중간 연산
                .collect(Collectors.toList());          // 스트림을 리스트로 변환
*/
        
        // v3. 람다
        List<String> bookNameList = books.stream()      // 리스트에서 스트림 얻기
                .filter(book -> {
                    System.out.println("book.getPrice() = " + book.getPrice());
                    return book.getPrice() > 4000;
                }) // 중간 연산
                .map(book -> book.getName())            // 중간 연산
                .limit(10)                       // 중간 연산
                .collect(Collectors.toList());          // 스트림을 리스트로 변환

        for (String title : bookNameList) {
            System.out.println("title = " + title);
        }


    }

    public static class Book {
        String name;
        int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }



}



