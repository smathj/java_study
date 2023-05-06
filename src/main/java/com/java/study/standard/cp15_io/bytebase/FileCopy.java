package com.java.study.standard.cp15_io.bytebase;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

    public static void main(String[] args) {

        try (
                FileInputStream fis = new FileInputStream("C:\\io\\myTxt.txt");
                FileOutputStream fos = new FileOutputStream("C:\\io\\copy_myTxt.txt");
        ) {
            // 읽어온 데이터 갯수
            int data = 0;


            while (data != -1) {
                if(data == -1) break;

                data = fis.read();
                char c = (char) data;
                System.out.print(c);

                fos.write(data);    // void write(int b);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
