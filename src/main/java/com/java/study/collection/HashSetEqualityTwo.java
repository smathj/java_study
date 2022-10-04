package com.java.study.collection;


import java.util.HashSet;

class Num {
    private int num;
    public Num(int n ) { this.num = n; }

    // 문자열로 리턴
    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int hashCode() {
        return num % 3; // num의 값이 같으면 부류도 같다
    }

    @Override
    public boolean equals(Object obj) {
        // 값 비교
        if (this.num == ((Num) obj).num) {
            return true;
        } else {
            return false;
        }
    }
}


public class HashSetEqualityTwo {
    public static void main(String[] args) {
        HashSet<Num> set = new HashSet<>();
        set.add(new Num(7799));
        set.add(new Num(9955));
        set.add(new Num(7799));
        System.out.println("인스턴스 수: " + set.size());
        System.out.println(new Num(7799).hashCode());
        System.out.println(new Num(7799).hashCode());
        for (Num n : set) {
            System.out.println(n.toString());
        }
    }
}
