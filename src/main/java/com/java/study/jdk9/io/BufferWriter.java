package com.java.study.jdk9.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferWriter {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story2.txt");

        BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);

        bw.write("안녕");
        bw.newLine();
        bw.write("즐");

        bw.close();
    }
}
