package com.java.study.fire.iostream.filterStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class BufferedDataOutputStream {
    public static void main(String[] args) {
        try(
                DataOutputStream out = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("data.dat")
                        )
                ))
        {
            //                          2bytes 2bytes
                out.writeInt(370);  // 0000 0172  = 370
                out.writeDouble(3.14);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
