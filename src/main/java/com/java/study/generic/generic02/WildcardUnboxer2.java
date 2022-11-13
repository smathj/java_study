package com.java.study.generic.generic02;



class Box4<T> {
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

class Unboxer2 {
    public static <T> T openBox(Box<T> box) {
        return box.get();
    }

    // 상자 안의 내용물을 확인하는(출력하는) 기능의 제네릭 메소드
    // ! 와일드 카드 ? 사용
    public static void peekBox(Box<?> box) {
        System.out.println(box);
    }
}


public class WildcardUnboxer2 {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("간단한 문자열입력");
        Unboxer2.peekBox(box);
    }
}
