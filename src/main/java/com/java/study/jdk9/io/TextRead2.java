package com.java.study.jdk9.io;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextRead2 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story.txt");


        List<String> textList = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String text : textList) {
            System.out.println(text);
        }


    }
}
