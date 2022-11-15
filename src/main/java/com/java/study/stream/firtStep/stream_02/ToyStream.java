package com.java.study.stream.firtStep.stream_02;


import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo {
    private String model;
    private int price;

    public ToyPriceInfo(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class ToyStream {
    public static void main(String[] args) {
        List<ToyPriceInfo> ls = new ArrayList<>();
        ls.add(new ToyPriceInfo("건담01", 200));
        ls.add(new ToyPriceInfo("건담02", 350));
        ls.add(new ToyPriceInfo("건담03", 500));

        int sum = ls.stream()
                .filter(p -> p.getPrice() < 500)
                .mapToInt(t -> t.getPrice())
//                 메서드참조
//                .mapToInt(ToyPriceInfo::getPrice)
                .sum();

        System.out.println("sum = " + sum);

    }
}
