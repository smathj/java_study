package com.java.study.fire.iostream.characterStream;

import java.io.FileReader;
import java.io.Reader;

public class TextReader {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("읽을 파일: ");
//        String src = sc.nextLine();

        String src = "C:\\Users\\KSJ\\Desktop\\tip\\ssl.txt";
        try(
            Reader in = new FileReader(src); // 문자 입력 스트림 생성
                )
        {
            int ch;

            while (true) {
                ch = in.read();
                if (ch == -1) {
                    break;
                } else {
                    System.out.print((char)ch);
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
