package com.java.study.iostream.filterStream;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class BufferedStreamFileCopier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 파일: ");
        String src = sc.nextLine();

        System.out.print("사본 이름: ");
        String dst = sc.nextLine();

        Instant start = Instant.now();

        try (
                // 8 kb
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst)))
        {
            int data;
            while (true) {
                data = in.read();   // 파일로부터 1바이트를 읽는다
                if (data == -1) {   // 더이상 읽을 데이터가 없으면 -1를 리턴함 ㅇㅇ
                    break;          // 멈췃!
                } else {
                    out.write(data);    // 파일에 1바이트를 쓴다
                }
            }
            Instant end = Instant.now();

            System.out.println(Duration.between(start, end).toMillis());
            // loream.txt : 130 밀리초

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
