package com.java.study.modern.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bag {
    private String name;
    private int price;
    private String brand;

    public Bag(String name) {
        this.name = name;
    }

    public Bag(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}


public class MyTest {
    public static void main(String[] args) {
        List<Bag> bagList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            bagList.add(new Bag("가방" + i, i * 1000, "순양가방"));
        }

        List<Bag> nameBagList = bagList.stream()
                .filter((Bag bag) -> bag.getPrice() < 5000)
//                .filter((Bag bag) -> bag.getName().equals("가방1"))
//                .map((Bag bag) -> new Bag(bag.getName(), bag.getPrice(), bag.getBrand()))
                .collect(Collectors.toList());

        System.out.println("nameBagList = " + nameBagList);

    }



}
