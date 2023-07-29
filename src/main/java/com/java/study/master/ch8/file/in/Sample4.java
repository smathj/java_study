package com.java.study.master.ch8.file.in;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample4 {

    /**
     * JDK7 이후
     */
    public static void main(String[] args) {

        Path path = Paths.get("C:/Users/KSJ/Desktop/tip/ssl.txt");

        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            // 파일을 한줄 씩 읽는다
            for (String line; (line = reader.readLine()) != null; ) {
                System.out.println("line = " + line);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
