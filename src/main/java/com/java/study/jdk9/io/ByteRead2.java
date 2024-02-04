package com.java.study.jdk9.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteRead2 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/readme.txt");

        try(InputStream in = new FileInputStream(path.toFile());) {

            byte[] bytes = in.readAllBytes();
            System.out.println("bytes.length = " + bytes.length);

        } catch(Exception e) {
            e.printStackTrace();
        }





    }
}
