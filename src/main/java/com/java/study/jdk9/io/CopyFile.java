package com.java.study.jdk9.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/readme.txt");

        String copyFile = "src/main/java/com/java/study/jdk9/io/copy.txt";
        try(InputStream in = new FileInputStream(path.toFile()); OutputStream out = new FileOutputStream(copyFile)) {

            System.out.println("파일을 복사합니다");
            in.transferTo(out);

        } catch(Exception e) {
            e.printStackTrace();
        }





    }
}
