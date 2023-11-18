package com.java.study.first.ch12_io;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test13 {

    public static void main(String[] args) {
        final String zipFileName = "";
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {

            ZipEntry zipEntry = new ZipEntry("1번파일.xlsx");
            zos.putNextEntry(zipEntry);
            byte[] data = Files.readAllBytes(Paths.get(""));
            zos.write(data);

            zipEntry = new ZipEntry("2번파일.xlsx");
            zos.putNextEntry(zipEntry);
            byte[] data2 = Files.readAllBytes(Paths.get(""));
            zos.write(data2);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
