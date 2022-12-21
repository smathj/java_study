package com.java.study.fire.collection2.ex02;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car implements Comparable<Car> {

    protected int disp; // 배기량

    public Car(int disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return "cc: " + disp;
    }


    @Override
    public int compareTo(Car o) {
        return disp - o.disp;   // 오름 차순
    }
}


// * Car를 상속함으로서, 간접적으로 Comparable<Car> 구현이 되었다
class ECar extends Car {    // 전기 자동차를 표현한 클래스이다
    private int battery;    // 배터리

    public ECar(int disp, int battery) {
        super(disp);
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "cc : " + disp + ", ba : " + battery;
    }


}




public class EcarSortCollections {
    public static void main(String[] args) {
        List<ECar> list = new ArrayList<>();
        list.add(new ECar(1200, 99));
        list.add(new ECar(3000, 55));
        list.add(new ECar(1800, 87));
        Collections.sort(list); // Comparable<Car> 이용 ( 연비 기준 오름 차순 )

        for (ECar eCar : list) {
            System.out.println(eCar);
        }
    }
}
