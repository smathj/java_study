package com.java.study.playground;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        if (input1.length() >= 100) {
            input1 = in.next();
        }

        String[] textArr = input1.split("");
        String result = "";
        for (int i = 0; i < textArr.length; i++) {
            char oriChar = textArr[i].charAt(0);
            char upperChar = textArr[i].toUpperCase().charAt(0);

            // 원본이 대문자인경우
            if (oriChar == upperChar) {
                result += textArr[i].toLowerCase();
            // 원본이 소문자인경우
            } else {
                result += textArr[i].toUpperCase();
            }
        }
        System.out.println(result);
        return ;
    }
}
