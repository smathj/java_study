package com.java.study.fire.nested.inner;

class Outer {
    private int num = 0;

    // Outer 클래스의 멤버 클래스 : 클래스의 정의를 감추어야 할 때 사용
    class Member {
        void add(int n ) { num += n; }
        int get() { return num; }
    }
}


public class MemberInner {
    public static void main(String[] args) {
        Outer o1 = new Outer();
        Outer o2 = new Outer();

        // o1 기반으로 두 인스턴스 생성
        Outer.Member o1m1 = o1.new Member();
        Outer.Member o1m2 = o1.new Member();

        // o2 기반으로 두 인스턴스 생성
        Outer.Member o2m1 = o2.new Member();
        Outer.Member o2m2 = o2.new Member();

        // o1 기반으로 생성된 두 인스턴스의 메소드 호출
        o1m1.add(5);
        System.out.println(o1m2.get());

        // o2 기반으로 생성된 두 인스턴스의 메소드 호출
        o2m1.add(7);
        System.out.println(o2m2.get());



    }
}
