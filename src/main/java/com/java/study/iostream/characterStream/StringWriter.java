package com.java.study.iostream.characterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class StringWriter {
    public static void main(String[] args) {
        String ks = "돈은 언제벌어서 또 강의사고 또 언제 완강하고, 언제 코테 공부해서 이직하냐... 인생";
        String es = "I'm so Sad... Help me plz";

        try(BufferedWriter bw = new BufferedWriter(
                new FileWriter("String.txt")
        )) {
            bw.write(ks, 0, ks.length());
            bw.newLine();   // 줄바꿈
            bw.write(es, 0, es.length());

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
