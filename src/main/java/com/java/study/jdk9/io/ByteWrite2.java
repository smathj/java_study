package com.java.study.jdk9.io;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteWrite2 {

    public static void main(String[] args) throws Exception {

//        Path path = Paths.get("com/java/study/jdk9/io/readme.txt");
        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/write.txt");

        try (FileOutputStream fos = new FileOutputStream(path.toFile());) {
            fos.write(1);
            fos.write(new byte[]{1, 2});

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
