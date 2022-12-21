package com.java.study.fire.iostream.inInstance;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOUtput {
    public static void main(String[] args) {
        SBox box1 = new SBox("Robot");
        SBox box2 = new SBox("Strawberry");

        try(ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Object.bin"))) {

            oo.writeObject(box1);
            oo.writeObject(box2);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
