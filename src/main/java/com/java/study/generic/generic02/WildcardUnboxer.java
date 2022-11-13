package com.java.study.generic.generic02;



class Box3<T> {
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

class Unboxer {
    public static <T> T openBox(Box<T> box) {
        return box.get();
    }

    // 상자 안의 내용물을 확인하는(출력하는) 기능의 제네릭 메소드
    public static <T> void peekBox(Box<T> box) {
        System.out.println(box);
    }
} 


public class WildcardUnboxer {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("간단한 문자열");
        Unboxer.peekBox(box);   // 상자 안의 내용물을 확인해본다
    }
}
