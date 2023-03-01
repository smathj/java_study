package com.java.study.standard.ch10_format;

import java.text.DecimalFormat;

public class DecimalFormatEx2 {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#,##.##");
        DecimalFormat df2 = new DecimalFormat("#,###E0");

        try {

            Number num = df.parse("1,234,567.89");
            System.out.print("1,234,567.89" + " -> ");

            double d = num.doubleValue();
            System.out.print(d + " -> ");

            System.out.println(df2.format(num));


            int intValue = num.intValue();
            System.out.println("intValue = " + intValue);

            long longValue = num.longValue();
            System.out.println("longValue = " + longValue);

            float floatValue = num.floatValue();
            System.out.println("floatValue = " + floatValue);


            float f1 = 1f;
            double d1 = 1;

            short s1 = 1;
            char c1 = 'a';

            System.out.println("c1 = " + c1);





        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
