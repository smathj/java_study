package com.java.study.generic.generic02;


class Box9<T> {
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

class Toy3 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxContentsMover {
    public static void moveBox(Box9<? super Toy3> to, Box9<? extends Toy3> from) {
        to.set(from.get());
    }
}

public class MoveBoxContents {
    public static void main(String[] args) {
        Box9<Toy3> box1 = new Box9<>();
        box1.set(new Toy3());
        Box9<Toy3> box2 = new Box9<>();

        // box1에 저장된 내용물을 box2로 이동
        BoxContentsMover.moveBox(box2, box1);
        System.out.println(box2.get());
    }
}
