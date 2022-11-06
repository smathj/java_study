package com.java.study.iostream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Read7FromFile {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("data.dat");
        int dat = in.read();    // 데이터 읽음
        in.close();

        System.out.println("dat = " + dat);
        
    }
}
