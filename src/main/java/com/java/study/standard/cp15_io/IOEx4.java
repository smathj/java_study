package com.java.study.standard.cp15_io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx4 {

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

                int len = input.read(temp); // 읽어온 데이터 수
                System.out.println("len = " + len);
                output.write(temp, 0, len); // temp 바구니에 0부터 읽어온 갯수까지만 짤라서 넣는다 (덮어쓰기된 과거데이터부분은 버리기 위해서)

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
