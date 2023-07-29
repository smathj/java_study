package com.java.study.master.ch8.file.in;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample1 {

    public static void main(String[] args) {

        String separator = File.separator;
        System.out.println("separator = " + separator);
        File file = Paths.get("C:" + separator + "test_folder").toFile();
        file.mkdirs();

        URI uri = URI.create("file:///C:/test_folder");
        Path path = Paths.get(uri);
        System.out.println("path = " + path);

        Path path1 = Paths.get("C:/test_folder");
        Path absolutePath = path1.toAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);

        Path path2 = Paths.get(".");
        Path absolutePath1 = path2.toAbsolutePath();
        System.out.println("absolutePath1 = " + absolutePath1);


    }
}
