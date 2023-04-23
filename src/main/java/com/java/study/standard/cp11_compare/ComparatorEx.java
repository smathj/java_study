package com.java.study.standard.cp11_compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

    /**
     * Comparable : 기본 정렬기준 사용
     * Comparator : 다른 정렬기준으로 사용 ( 커스텀 )
     * 앞이크면 1, 같으면 0, 작으면 -1
     */
    public static void main(String[] args) {

        // 기본정렬은 대문자먼저 오름차순
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);    // String의 Comparable 사용
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 역순정렬
        System.out.println("strArr = " + Arrays.toString(strArr));

    }
}


class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;    // ex. Integer는 Comparable을 구현체이다
            Comparable c2 = (Comparable) o2;    // ex. String도 Comparable의 구현체이다
            // -1 을 곱해서 기본정렬방식의 역으로 변경한다
            // c2.compareTo(c1)도 가능하다
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}