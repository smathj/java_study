package com.java.study.fire.iostream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Read7FromFile2 {
    public static void main(String[] args) throws Exception {

        InputStream in = null;

        try {
            in = new FileInputStream("data.dat");
            int dat = in.read();    // 데이터 읽음
            System.out.println("dat = " + dat);

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
