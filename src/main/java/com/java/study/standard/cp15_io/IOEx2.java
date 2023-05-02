package com.java.study.standard.cp15_io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx2 {

    public static void main(String[] args) throws IOException {

        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data = 0;

        input.read(temp, 0, temp.length);   // 첨부터 끝가지 읽는다
        output.write(temp, 5, 5);   // temp[5] 부터 5개의 데이터를 write한다 ( off는 offset )

        outSrc = output.toByteArray();

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("temp Source : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }
}
