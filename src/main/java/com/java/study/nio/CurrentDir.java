package com.java.study.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentDir {
    public static void main(String[] args) {
        Path cur = Paths.get("");   // 현재 딜덱토리 정보 담긴 인스턴스 생성한다
        String cdir;

        if (cur.isAbsolute()) {
            System.out.println("cur.isAbsolute() : " + cur.isAbsolute());
            cdir = cur.toString();
        } else {
            System.out.println("cur.isAbsolute() : " + cur.isAbsolute());
            cdir = cur.toAbsolutePath().toString();
        }
        System.out.println("Current dir: " + cdir);

    }
}
