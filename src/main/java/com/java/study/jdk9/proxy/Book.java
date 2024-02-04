package com.java.study.jdk9.proxy;

import lombok.Getter;

public class Book implements BookInterface {

    private String bookName;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String bookName() {
        return this.bookName;
    }
}
