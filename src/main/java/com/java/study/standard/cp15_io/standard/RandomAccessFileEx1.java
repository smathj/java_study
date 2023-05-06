package com.java.study.standard.cp15_io.standard;

import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {

    public static void main(String[] args) {

        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\io\\StandardIOEx3.txt", "rw");
            System.out.println("파일 포인터 위치 : " + raf.getFilePointer());
            raf.writeInt(100);

            System.out.println("파일 포인터 위치 : " + raf.getFilePointer());
            raf.writeLong(100L);

            System.out.println("파일 포인터 위치 : " + raf.getFilePointer());

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
