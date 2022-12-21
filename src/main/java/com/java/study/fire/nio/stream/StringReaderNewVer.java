package com.java.study.fire.nio.stream;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringReaderNewVer {
    public static void main(String[] args) {
        Path fp = Paths.get("String.txt");

        try(BufferedReader br = Files.newBufferedReader(fp)) {
            String str;
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(str);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
