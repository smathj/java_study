package com.java.study.variable;

public class Varargs {

    public static void showAll(String ...vargs) {
        System.out.println("LEN : " + vargs.length);
        System.out.println("vargs's Type : " + vargs.getClass().getSimpleName());   // String[]


        for (String s : vargs) {
            System.out.print(s + '\t');
        }
        System.out.println();
    }



    public static void main(String[] args) {
        showAll("Box");
        showAll("Box", "Toy");
        showAll("Box", "Toy", "Apple");
    }
}
