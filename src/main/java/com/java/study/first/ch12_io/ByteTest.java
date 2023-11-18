package com.java.study.first.ch12_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteTest {

    public static void main(String[] args) throws IOException {

        String path = "";
        String path2 = "";
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(path2);

        byte[] buffer = new byte[4096]; // 4 kb

        System.out.println("파일을 읽습니다");
        while (fis.read(buffer) != -1) {
            fos.write(buffer, 0, buffer.length);
        }
        System.out.println("파일 복사완료");



    }
}
