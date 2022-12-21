package com.java.study.fire.generic.generic02;

class Box2<T> {
    protected T ob;

    public T get() {
        return ob;
    }

    public void set(T o) {
        this.ob = o;
    }
}


class EmptyBoxFactory {
    public static <T> Box2<T> makeBox() {
        Box2<T> box = new Box2<T>();
        return box;
    }

}


public class TargetTypes {
    public static void main(String[] args) {
        Box2<Integer> iBox = EmptyBoxFactory.<Integer>makeBox();
//        Box2<Integer> iBox = EmptyBoxFactory.makeBox();
        iBox.set(25);
        System.out.println(iBox.get());
    }
}
