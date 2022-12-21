package com.java.study.fire.generic.generic02;



class Box5<T> {
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

class Unboxer3 {
    // 상향 제한, Number 하위
    public static void peekBox(Box<? extends Number> box) {
        System.out.println(box);
    }
}


public class UpperBoundedWildcard {
    public static void main(String[] args) {
        Box<Integer> ibox = new Box<>();
        ibox.set(1234);

        Box<Double> dbox = new Box<>();
        dbox.set(3.17);

        Unboxer3.peekBox(ibox);
        Unboxer3.peekBox(dbox);
    }
}
