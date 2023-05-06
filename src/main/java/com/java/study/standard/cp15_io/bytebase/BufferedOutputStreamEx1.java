package com.java.study.standard.cp15_io.bytebase;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx1 {

    public static void main(String[] args) {

        try {

            FileOutputStream fos = new FileOutputStream("C:\\io\\123.txt");

            // Buffer 크기 5
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);

            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }

            bos.close();
//            fos.close();  // 안써도됨

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
