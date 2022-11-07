package com.java.study.nio.stream;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringWriterNewVer {
    public static void main(String[] args) {
        String ks = "자바를 믿어라 !!! 노드 가지마 !!";
        String es = "Java is King";

        Path fp = Paths.get("String.txt");

        // Files.newBufferedWriter(fp) 는 다음과 같다 new BufferdWriter(new FileWriter())
        try(BufferedWriter bw = Files.newBufferedWriter(fp)) {
            bw.write(ks, 0, ks.length());
            bw.newLine();
            bw.write(es, 0, es.length());


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
