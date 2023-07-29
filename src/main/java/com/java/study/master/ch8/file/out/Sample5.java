package com.java.study.master.ch8.file.out;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample5 {

    /**
     * JDK7 이후
     */
    public static void main(String[] args) {

        Path path = Paths.get("C:/test_folder/3.txt");

        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            writer.append("ㅎㅇ?");
            writer.newLine();
            writer.append("ㅂㅇ");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
