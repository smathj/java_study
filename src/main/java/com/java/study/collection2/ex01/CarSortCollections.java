package com.java.study.collection2.ex01;


import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

class Car implements Comparable<Car> {

    private int disp;   // 배기량

    public Car(int d) {
        this.disp = d;
    }


    public String toString() {
        return "cc: " + disp;
    }

    // 오름 차순
    public int compareTo(Car o) {
        System.out.println("disp : " + disp);
        System.out.println("o.disp : " + o.disp);
        System.out.println("disp - o.disp : " + (disp - o.disp));
        System.out.println();
        return disp - o.disp;
    }
}

public class CarSortCollections {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1200));
        list.add(new Car(3000));
        list.add(new Car(1800));
        Collections.sort(list);

        System.out.println("--------------------------------");
        for (Car car : list) {
            System.out.println(car.toString());
        }
    }
}
