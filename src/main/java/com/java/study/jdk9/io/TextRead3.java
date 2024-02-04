package com.java.study.jdk9.io;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TextRead3 {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story.txt");


        try(Stream<String> lineStream = Files.lines(path)) {

            lineStream.forEach(System.out::println);

        } catch(Exception e) {
            e.printStackTrace();
        };





    }
}
