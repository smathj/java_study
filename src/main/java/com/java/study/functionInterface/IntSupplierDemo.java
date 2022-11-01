package com.java.study.functionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class IntSupplierDemo {

    public static List<Integer> makeIntList(IntSupplier is, int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(is.getAsInt());
        }
        return list;
    }


    public static void main(String[] args) {
        IntSupplier spr = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        List<Integer> list = makeIntList(spr, 10);  // 10회
        System.out.println(list);

        list = makeIntList(spr, 10);
        System.out.println(list);
    }
}
