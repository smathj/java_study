package com.java.study.fire.iostream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write7ToFile {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        System.out.println("path = " + path);

        Path relativePath = Paths.get("");
        String path2 = relativePath.toAbsolutePath().toString();
        System.out.println("path2 = " + path2);

        OutputStream out = new FileOutputStream("data.dat");
        out.write(7);
        out.close();
    }
}
