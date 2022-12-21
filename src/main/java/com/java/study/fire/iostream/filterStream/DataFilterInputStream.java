package com.java.study.fire.iostream.filterStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataFilterInputStream {
    public static void main(String[] args) {
        try(DataInputStream in = new DataInputStream(new FileInputStream("data.dat"))) {
            int num1 = in.readInt();
            double num2 = in.readDouble();

            System.out.println("num1 = " + num1);
            System.out.println("num2 = " + num2);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
