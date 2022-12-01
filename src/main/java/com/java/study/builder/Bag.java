package com.java.study.builder;

public class Bag {

    private final String name;
    private final int price;
    private final String brand;


    public Bag(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }


    protected static InnerClassBuilder Builder() {
        return new InnerClassBuilder();
    }


    protected static class InnerClassBuilder {
        private String name;
        private int price;
        private String brand;



        public InnerClassBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InnerClassBuilder price(int price) {
            this.price = price;
            return this;
        }

        public InnerClassBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Bag build() {
            return new Bag(name, price, brand);
        }


    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}
