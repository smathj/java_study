package com.java.study.fire.iostream.characterStream;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringReader {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(
                new FileReader("lorem.txt")
        )) {
            String str;
            while (true) {
                str = br.readLine();    // 한 문장 읽어 들이기
                if (str == null) {
                    break;
                } else {
                    System.out.println(str);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
