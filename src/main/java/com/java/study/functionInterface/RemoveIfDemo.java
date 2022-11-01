package com.java.study.functionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
        ls1 = new ArrayList<>(ls1);

        List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
        ls2 = new ArrayList<>(ls2);

        Predicate<Number> p = n -> n.doubleValue() < 0.0;   // 삭제의 조건 ( 음수 지우기 )
        ls1.removeIf(p);    // List<Integer> 인스턴스에 삭제 조건 전달
        ls2.removeIf(p);    // List<Double> 인스턴스에 삭제 조건 전달

        // * Integer 또는 Double 는 Number를 상속한다
        
        System.out.println(ls1);
        System.out.println(ls2);






    }
}
