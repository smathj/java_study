package com.java.study.fire.generic.generic02;

class Box8<T> {
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

class Toy2 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler2 {

    public static void outBox(Box8<Toy2> box) {
        Toy2 t = box.get(); // 상자에서 꺼내기
        System.out.println(t);
    }

    public static void inBox(Box8<Toy2> box, Toy2 n) {
        box.set(n); // 상자에 넣기
    }
}

public class BoundedWildcardUsage2 {
    public static void main(String[] args) {
        Box8<Toy2> box = new Box8<>();
        BoxHandler2.inBox(box, new Toy2());
        BoxHandler2.outBox(box);
    }
}
