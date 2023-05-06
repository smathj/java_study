package com.java.study.standard.cp15_io.characterbase;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx1 {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\standard\\cp15_io\\characterbase\\BufferedReaderEx1.java");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            for (int i = 1; (line = br.readLine()) != null; i++) {
                // ";"를 포함한 라인을 출력한다.
                if (line.indexOf(";") != -1) {
                    System.out.println(i + ":" + line);
                }
            }

            br.close();
            // 자동 fr.close()


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
