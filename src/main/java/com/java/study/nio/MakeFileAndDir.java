package com.java.study.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeFileAndDir {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\empty.txt");
        fp = Files.createFile(fp);  // 파일 생성

        Path dp1 = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\Empty");
        dp1 = Files.createDirectory(dp1);   // 디렉토리 생성

        Path dp2 = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\Empty\\Empty\\Empty");
        dp2 = Files.createDirectories(dp2);   // 디렉토리 생성

        System.out.println("File: " + fp);
        System.out.println("Dir1: " + dp1);
        System.out.println("Dir2: " + dp2);



    }
}
