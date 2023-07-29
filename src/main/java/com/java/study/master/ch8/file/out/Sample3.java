package com.java.study.master.ch8.file.out;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Sample3 {
    public static void main(String[] args) {

        Path path = Paths.get("C:/test_folder/2.txt");
        byte[] data = new byte[]{0x41, 0x42, 0x43};  // A, B, C

        // 파일 끝에 추가, 파일 없으면 생성, 쓰기 기능으로 연다
        try {
            Path resultPath = Files.write(path, data, StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            System.out.println("resultPath = " + resultPath);


        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
