package com.java.study.master.ch8.file.in;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample2 {

    public static void main(String[] args) {

        Path path = Paths.get("C:/test_folder/1.txt");

        // try-with-resources 구문으로 리소스 닫기
        // Files와 Path를 이용해서 간결하게 io 얻기
        try(InputStream is = Files.newInputStream(path)) {

            for (int ch; (ch = is.read()) != -1; ) {
                System.out.println((char) ch);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }



    }
}
