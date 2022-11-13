package com.java.study.generic.generic02;

class Box7<T> {
    protected T ob;

    public T get() {
        return ob;
    }

    public void set(T o) {
        this.ob = o;
    }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler {

    public static void outBox(Box7<Toy> box) {
        Toy t = box.get();
        System.out.println(t);
    }

    public static void inBox(Box7<Toy> box, Toy n) {
        box.set(n);
    }
}

public class BoundedWildcardBase {
    public static void main(String[] args) {
        Box7<Toy> box = new Box7<>();
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);
    }
}
