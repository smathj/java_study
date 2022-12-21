package com.java.study.fire.iostream.characterStream;

import java.io.FileWriter;
import java.io.Writer;

public class TextWriter {
    public static void main(String[] args) {
        try(Writer out = new FileWriter("data.txt")) {  // 문자 출력 스트림 생성
            for (int ch = (int) 'A'; ch < (int) ('Z' + 1); ch++) {
                out.write(ch);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
