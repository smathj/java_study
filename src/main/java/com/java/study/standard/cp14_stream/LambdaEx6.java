package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx6 {




    public static void main(String[] args) {

        // 파라미터 x , 리턴 o
        IntSupplier s = () -> (int) (Math.random() * 100) + 1;

        // 파라미터 o, 리턴 x
        IntConsumer c = i -> System.out.print(i + ",");

        // 파라미터 o, 리턴 o (boolean 고정)
        IntPredicate p = i -> i % 2 == 0;

        // 파라미터 o, 리턴 o
        IntUnaryOperator op = i -> i / 10 * 10;    // i의 일의 자리를 없앤다


        int[] arr = new int[10];

        makeRandomList(s, arr);
        System.out.println(Arrays.toString(arr));

        printEvenNum(p, c, arr);

        int[] newArr = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));

    }



    static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
        System.out.print("[");

        for (int i: arr) {
            if (p.test(i)) {        // 리턴 타입 boolean
                c.accept(i);        // 리턴 타입 void
            }
        }

        System.out.println("]");
    }

    static <T> void makeRandomList(IntSupplier s, int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = s.getAsInt();
        }
    }

    static int[] doSomething(IntUnaryOperator op, int[] arr) {

        int[] newArr = new int[arr.length];


        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = op.applyAsInt(arr[i]);

        }

        return newArr;
    }



}
