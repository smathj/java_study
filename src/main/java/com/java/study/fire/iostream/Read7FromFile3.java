package com.java.study.fire.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Read7FromFile3 {
    public static void main(String[] args) {
        try(InputStream in = new FileInputStream("data.dat")) {
            int dat = in.read();
            System.out.println(dat);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
