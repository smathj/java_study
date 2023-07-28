package com.java.study.bbang.ch13;

import java.text.DecimalFormat;

public class Sample03 {

    public static void main(String[] args) {

        int myMoney = -5000;
        System.out.println("myMoney = " + myMoney);
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println(df.format(myMoney));

    }
}
