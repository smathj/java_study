package com.java.study.jdk9.io;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferRead2 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story.txt");

        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        br.lines().forEach((System.out::println));

        br.close();
    }
}
