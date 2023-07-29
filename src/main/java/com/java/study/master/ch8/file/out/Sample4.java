package com.java.study.master.ch8.file.out;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample4 {

    /**
     * JDK6 이전
     */
    public static void main(String[] args) {

        Path path = Paths.get("C:/test_folder/3.txt");
        File file = path.toFile();

        BufferedWriter writer = null;

        try {

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));

            writer.append("ㅎㅇ?");
            writer.newLine();
            writer.append("ㅂㅇ");

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
