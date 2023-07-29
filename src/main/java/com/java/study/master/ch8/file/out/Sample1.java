package com.java.study.master.ch8.file.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample1 {

    /**
     * JDK6 이전 방식
     */
    public static void main(String[] args) {

        Path path = Paths.get("C:/test_folder/2.txt");
        File file = path.toFile();

        OutputStream writer = null;

        try {
            writer = new FileOutputStream(file, true);
            writer.write(1);
            writer.write(2);
            writer.write(3);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }


    }
}
