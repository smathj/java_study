package com.java.study.playground;


public class Book {

    private final String title;
    private final int price;

    private final String writer;

    // ! 정적 멤버 클래스
    public static class Builder {

        // * 필수 입력
        private String title;
        private int price;

        // ? 선택사항
        private String writer;

        // 정적 클래스의 필수 입력 생성자
        public Builder(String title, int price) {
            this.title = title;
            this.price = price;
        }

        // 정적 클래스의 title 셋터역할
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        // 정적 클래스의 price 셋터역할
        public Builder price(int price) {
            this.price = price;
            return this;
        }

        // 정적 클래스의 writer 셋터역할
        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }


        public Book build() {
            return new Book(this);
        }
    }

    // * Book 생성자, 파라미터가 Builder임
    public Book(Builder builder) {
        this.title = builder.title;
        this.price = builder.price;
        this.writer = builder.writer;
    }



    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", writer='" + writer + '\'' +
                '}';
    }
}
