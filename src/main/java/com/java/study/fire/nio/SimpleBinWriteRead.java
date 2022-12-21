package com.java.study.fire.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SimpleBinWriteRead {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\empty.txt");

        // * 파일 생성, 파일이 존재하면 예외 발생한다
        fp = Files.createFile(fp);

        byte buf1[] = {0x13, 0x14, 0x15};   // 파일에 쓸 데이터
        for (byte b : buf1) {
            System.out.print(b + "\t");
        }
        System.out.println();
        
        // * 파일에 데이터 쓰기
        Files.write(fp, buf1, StandardOpenOption.APPEND);
        
        // * 파일로부터 데이터 읽기
        byte buf2[] = Files.readAllBytes(fp);

        for (byte b : buf2) {   // 읽어 들인 데이터의 출력을 위한 반복문
            System.out.print(b + "\t");
        }
        System.out.println();


    }
}
