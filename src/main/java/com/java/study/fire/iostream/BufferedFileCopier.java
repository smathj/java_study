package com.java.study.fire.iostream;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class BufferedFileCopier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 파일: ");
        String src = sc.nextLine();

        System.out.print("사본 이름: ");
        String dst = sc.nextLine();

        Instant start = Instant.now();

        try (
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dst))
        {
            byte buf[] = new byte[1024]; // 1 kb
            int len;

            while (true) {
                len = in.read(buf);   // 파일로부터 buf 크기만큼 읽는다
                if (len == -1) {   // 더이상 읽을 데이터가 없으면 -1를 리턴함 ㅇㅇ
                    break;          // 멈췃!
                } else {
                    out.write(buf, 0, len);    // len 바이트만큼 데이터를 저장한다
                }
            }
            Instant end = Instant.now();

            System.out.println(Duration.between(start, end).toMillis());
            // loream.txt : 200 밀리초

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
