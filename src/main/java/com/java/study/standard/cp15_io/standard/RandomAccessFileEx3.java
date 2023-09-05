package com.java.study.standard.cp15_io.standard;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {

    public static void main(String[] args) {

        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
            int i = 4;

            while (true) {
               raf.seek(i);
               sum += raf.readInt();
               i += 16;
            }


        } catch(EOFException eof) {
            System.out.println("sum = " + sum);
            eof.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
