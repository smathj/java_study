package com.java.study.fire.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(10, 10));
        pointList.add(new Point(1, 8));
        pointList.add(new Point(5, 2));
        pointList.add(new Point(1, 2));
        pointList.add(new Point(5, 5));
        pointList.add(new Point(10, 1));

        System.out.println("current list");
        for (Point temp : pointList) {
            System.out.println("x: " + temp.x + "  " + "y: " + temp.y);
        }

        MyComparator myComparator = new MyComparator();
        Collections.sort(pointList, myComparator);

        System.out.println("sorted list");
        for (Point temp : pointList) {
            System.out.println("x: " + temp.x + "  " + "y: " + temp.y);
        }
    }

}
