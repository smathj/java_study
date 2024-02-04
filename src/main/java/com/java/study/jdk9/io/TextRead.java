package com.java.study.jdk9.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextRead {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story.txt");


        byte[] bytes = Files.readAllBytes(path);

        String allText = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("allText = " + allText);



    }
}
