package com.java.study.iostream.characterStream;

import java.io.FileWriter;
import java.io.Writer;

public class SimpleWriter {
    public static void main(String[] args) {
        try(Writer out = new FileWriter("data.txt")) {
            out.write('A'); // 문자 'A' 저장
            out.write('한'); // 문자 '한' 저장
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
