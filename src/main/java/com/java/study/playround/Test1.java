package com.java.study.playround;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;


public class Test1 {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Book {

        private String bookName;
        private String brand;
        private int price;
        private String writer;
        private boolean soldOut;

    }

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("자바1", "백엔드출판사", 4000, "백엔드개발자", false));
        bookList.add(new Book("자바2", "백엔드출판사", 1500, "백엔드개발자", true));
        bookList.add(new Book("자바3", "자바출판사", 5500, "자바개발자", false));
        bookList.add(new Book("이것이리액트다", "리액트출판사", 3000, "리액트개발자", false));
        bookList.add(new Book("이것이뷰다", "뷰출판사", 3000, "뷰개발자", true));
        bookList.add(new Book("리액트의정석", "프론트출판사", 4200, "프론트개발자", true));
        bookList.add(new Book("뷰의정석", "프론트출판사", 6000, "프론트개발자", true));



        System.out.println("====== 제일 비싼 책 ======");
        Book maxBookV1 = bookList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Book::getPrice)), Optional::get));

        System.out.println("maxBookV1.getPrice() = " + maxBookV1.getPrice());
        System.out.println();


        Book maxBookV2 = bookList.stream()
                        .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Book::getPrice)), bookOption -> bookOption.get()));

        System.out.println("maxBookV2.getPrice() = " + maxBookV2.getPrice());
        System.out.println();


        Map<Boolean, List<Book>> soldOutMap = bookList.stream()
                .collect(Collectors.partitioningBy(Book::isSoldOut));

        List<Book> soldOutBookList = soldOutMap.get(true);
        List<Book> notSoldOutBookList = soldOutMap.get(false);


        System.out.println("====== 품절 책 ======");
        for (Book book : soldOutBookList) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("====== 판매중인 책 ======");
        for (Book book : notSoldOutBookList) {
            System.out.println(book);
        }
        System.out.println();


        // 브랜드 별 Book 리스트
        System.out.println("====== 브랜드 별 책 ======");
        Map<String, List<Book>> brandBookMap = bookList.stream()
                .collect(Collectors.groupingBy(Book::getBrand));

        for (String brand : brandBookMap.keySet()) {

            List<Book> bookListByBrand = brandBookMap.get(brand);
            for (Book book : bookListByBrand) {
                System.out.println(book);
            }
            System.out.println();
        }



        // 브랜드 별 Book 별 판매중인 책
        Map<Boolean, Map<String, List<Book>>> soldoutAndBrandGroupMap = bookList.stream()
                .collect(Collectors.groupingBy(Book::isSoldOut, Collectors.groupingBy(Book::getBrand)));

        Map<String, List<Book>> soldOutBrandGroupMap = soldoutAndBrandGroupMap.get(true);
        Map<String, List<Book>> nonSoldOutBrandGroupMap = soldoutAndBrandGroupMap.get(false);

        System.out.println("====== 품절인 브랜드 별 책 ======");
        for (String soldOutBrand : soldOutBrandGroupMap.keySet()) {
            List<Book> targetBookList = soldOutBrandGroupMap.get(soldOutBrand);
            for (Book book : targetBookList) {
                System.out.println(book);
            }
            System.out.println();
        }

        System.out.println("====== 판매중인인 브랜드 별 책 ======");
        for (String soldOutBrand : nonSoldOutBrandGroupMap.keySet()) {
            List<Book> targetBookList = nonSoldOutBrandGroupMap.get(soldOutBrand);
            for (Book book : targetBookList) {
                System.out.println(book);
            }
            System.out.println();
        }


        

        Map<Boolean, Map<String, Book>> soldOutAndBrandAndMaxPrice = bookList.stream()
                .collect(Collectors.partitioningBy(Book::isSoldOut,
                        Collectors.groupingBy(Book::getBrand,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Book::getPrice)), Optional::get))));


        Map<String, Book> soldOutMaxPricePerBrandMap = soldOutAndBrandAndMaxPrice.get(true);
        Map<String, Book> nonSoldOutMaxPricePerBrandMap = soldOutAndBrandAndMaxPrice.get(false);

        System.out.println("====== 품절 중인 브랜드 별 제일 비싼책 ======");
        for (String soldOutBrand : soldOutMaxPricePerBrandMap.keySet()) {
            Book book = soldOutMaxPricePerBrandMap.get(soldOutBrand);
            System.out.println(book);
        }
        System.out.println();

        System.out.println("====== 판매 중인 브랜드 별 제일 비싼책 ======");
        for (String soldOutBrand : nonSoldOutMaxPricePerBrandMap.keySet()) {
            Book book = nonSoldOutMaxPricePerBrandMap.get(soldOutBrand);
            System.out.println(book);
        }
        System.out.println();

    }


}
