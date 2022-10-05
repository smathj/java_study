package com.java.study.collection2.ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car {
    protected int disp; // 배기량

    public Car(int disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return "cc : " + disp;
    }
}

// Car의 정렬을 위한 클래스 ( 왜 Ecar로 안했는지 이해하는게 중요해 )
class CarComp implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.disp - o2.disp;   // [오름차순] 배기량 기준
//        return o2.disp - o1.disp;   // [내림차순] 배기량 기준
    }
}

class ECar extends Car {
    private int battery;

    public ECar(int disp, int battery) {
        super(disp);
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "cc : " + disp + ", ba : " + battery;
    }
}



public class CarComparator {
    public static void main(String[] args) {
        List<Car> clist = new ArrayList<>();
        clist.add(new Car(1800));
        clist.add(new Car(1200));
        clist.add(new Car(3000));

        List<ECar> elist = new ArrayList<>();
        elist.add(new ECar(3000, 55));
        elist.add(new ECar(1800, 87));
        elist.add(new ECar(1200, 99));

        // 정렬 클래스로 인스턴스 생성
        CarComp comp = new CarComp();

        // 각각 정렬 (두번째 파라미터가 하나의 인스턴스가 들어가는게 중요하다)
        Collections.sort(clist, comp);  // <- 당연히 되야하고
        Collections.sort(elist, comp);  // <- 이부분이 되는게 핵심

        for (Car car : clist) {
            System.out.println("car = " + car);
        }

        for (ECar eCar : elist) {
            System.out.println("eCar = " + eCar);
        }

    }
}
