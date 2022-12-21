package com.java.study.fire.generic.generic02;



class Box6<T> {
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

class Unboxer4 {
    // * 하한 제한
    public static void peekBox(Box6<? super Integer> box) {
        System.out.println(box);
    }
}


public class LowerBoundedWildcard {
    public static void main(String[] args) {
        Box6<Integer> ibox = new Box6<>();
        ibox.set(1234);

        Box6<Number> nbox = new Box6<>();
        nbox.set(9955);

        Box6<Object> obox = new Box6<>();
        obox.set("문자열을 몰래 적어봅니다");

        Unboxer4.peekBox(ibox);
        Unboxer4.peekBox(nbox);
        Unboxer4.peekBox(obox);
    }
}
