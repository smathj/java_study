package com.java.study.standard.cp15_io.standard;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class StandardIOEx3 {

    public static void main(String[] args) {

        PrintStream ps = null;
        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream("C:\\io\\StandardIOEx3.txt");
            ps = new PrintStream(fos);
            System.setOut(ps);

        } catch(Exception e) {
            System.err.println("File not found.");
        }

        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");

    }
}
