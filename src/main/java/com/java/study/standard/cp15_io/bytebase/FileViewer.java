package com.java.study.standard.cp15_io.bytebase;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {

    public static void main(String[] args) throws IOException {

        try(FileInputStream fis = new FileInputStream("C:\\jenkin.txt");) {

            int data = 0;

            while ((data = fis.read()) != -1) {
                char c = (char) data;
                System.out.print(c);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }


 /*
        FileInputStream fis = new FileInputStream("C:\\jenkin.txt");
        int data = 0;

        while ((data = fis.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
 */

    }
}
