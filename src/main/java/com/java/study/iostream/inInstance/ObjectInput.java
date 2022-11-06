package com.java.study.iostream.inInstance;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInput {
    public static void main(String[] args) {
        try(ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Object.bin"))) {
            SBox box1 = (SBox) oi.readObject(); // 인스턴스 복원
            System.out.println(box1.get());

            SBox box2 = (SBox) oi.readObject(); // 인스턴스 복원
            System.out.println(box2.get());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
