package com.java.study.fire.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFileFromFiles {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\Empty");
        Path dst = Paths.get("C:\\here");   // 폴더 자동 생성

        // src가 지시하는 디렉토리를 dst가 지시하는 디렉토리로 이동
        Files.move(src,dst, StandardCopyOption.REPLACE_EXISTING);


    }
}
