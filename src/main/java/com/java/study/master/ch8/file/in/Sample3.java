package com.java.study.master.ch8.file.in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Sample3 {

    /**
     * JDK6 이전
     */
    public static void main(String[] args) {

        File file = new File("C:/Users/KSJ/Desktop/tip/ssl.txt");

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            // 파일을 한줄씩 읽어들인다
            for (String line; (line = reader.readLine()) != null; ) {
                System.out.println("line = " + line);
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
