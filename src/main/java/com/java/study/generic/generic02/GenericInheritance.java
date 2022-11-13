package com.java.study.generic.generic02;


// 제네릭 상속

class Box<T> {
    protected T ob;

    public T get() {
        return ob;
    }

    public void set(T o) {
        this.ob = o;
    }
}


class SteelBox<T> extends Box {
    public SteelBox(T o) {
        ob = o;
//        super.ob = o;
    }
}

public class GenericInheritance {
    public static void main(String[] args) {
        Box<Integer> iBox = new SteelBox<>(7959);
        Box<String> sBox = new SteelBox<>("Simple");
        System.out.println(iBox.get());
        System.out.println(sBox.get());
    }
}
