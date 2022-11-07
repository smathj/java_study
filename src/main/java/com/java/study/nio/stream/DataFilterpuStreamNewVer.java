package com.java.study.nio.stream;

import java.io.DataInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFilterpuStreamNewVer {
    public static void main(String[] args) {
        Path fp = Paths.get("data.dat");

        try(DataInputStream in = new DataInputStream(Files.newInputStream(fp))) {

            int num1 = in.readInt();
            double num2 = in.readDouble();

            System.out.println("num1 = " + num1);
            System.out.println("num2 = " + num2);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
