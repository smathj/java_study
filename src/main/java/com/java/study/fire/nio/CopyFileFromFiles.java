package com.java.study.fire.nio;

import java.io.IOException;
import java.nio.file.*;

// ! 파일 복사
public class CopyFileFromFiles {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get("C:\\Users\\KSJ\\Desktop\\잡것\\개사진\\sibabeam.jpg");
        Path dst = Paths.get("C:\\Users\\KSJ\\Desktop\\잡것\\개사진\\시바빔.jpg");

        // src가 지시하는 파일을 dst가 지시하는 위치와 이름으로 복사한다
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
        //          A to B
    }
}
