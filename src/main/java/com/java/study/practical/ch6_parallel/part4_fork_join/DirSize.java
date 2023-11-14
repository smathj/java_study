package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

// 포크 조인을 사용하지 않는 방식
public class DirSize {

    protected Long compute(Path path) {
        long fileSize = 0;
        List<Path> fileList = null;
        try {
            fileList = Files.list(path).collect(Collectors.toList());


            for (Path file : fileList) {
                // 디렉터리
                if (Files.isDirectory(file)) {
                    fileSize += compute(file);
                    // 파일
                } else {
                    fileSize += Files.size(file);
                }
            }
        } catch (IOException e) {
            System.out.println("Error : " + path);
        }
        return fileSize;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Path rootPath = Paths.get("C:\\Program Files");

        DirSize dirSize = new DirSize();
        System.out.printf("합계 : %s 바이트%n", dirSize.compute(rootPath));
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        System.out.println("걸린시간(초) = " + (result / 1000));
    }

}
