package com.java.study.jdk9.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteRead {

    public static void main(String[] args) throws Exception {

//        Path path = Paths.get("com/java/study/jdk9/io/readme.txt");
        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/readme.txt");

        InputStream in = new FileInputStream(path.toFile());
        byte[] bytes = in.readAllBytes();
        System.out.println("bytes.length = " + bytes.length);

        in.close();

    }
}
