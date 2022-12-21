package com.java.study.fire.collection2.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LocationCompX implements Comparator<Location> {

    @Override
    public int compare(Location t1, Location t2) {
        if(t1.getX() > t2.getX()) {
            return 1;
        } else {
            return -1;
        }
    }
}


class LocationCompY implements Comparator<Location> {

    @Override
    public int compare(Location t1, Location t2) {
        if(t1.getX() == t2.getX() && t1.getY() > t2.getY()) {
            return 1;
        } else if(t1.getX() > t2.getX()) {
            return 1;
        } else {
            return -1;
        }
    }
}


public class Client {
    public static void main(String[] args) {
        List<Location> list = new ArrayList<>();
        list.add(new Location(1, 3));
        list.add(new Location(2, 3));
        list.add(new Location(3, 1));
        list.add(new Location(3, 3));
        list.add(new Location(1, 1));
        list.add(new Location(2, 1));
        list.add(new Location(3, 2));
        list.add(new Location(1, 4));
        list.add(new Location(2, 4));
        list.add(new Location(3, 4));
        list.add(new Location(1, 2));
        list.add(new Location(2, 2));

        Collections.sort(list, new LocationCompX());
        Collections.sort(list, new LocationCompY());

        for (Location location : list) {
            System.out.println(location);
        }

        // x 오름 차순, y 오름 차순
    }
}
