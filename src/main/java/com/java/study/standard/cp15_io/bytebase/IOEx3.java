package com.java.study.standard.cp15_io.bytebase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {

    public static void main(String[] args) throws IOException {

        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source : " + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {

                int available = input.available();
                System.out.println("남아있는 갯수 available = " + available);

                input.read(temp);
                output.write(temp);

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));
    }
}
