package com.java.study.standard.cp15_io.standard;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx3 {

    public static void main(String[] args) throws Exception {

        String fileName = "UserInfo2.ser";
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        ObjectOutputStream out = new ObjectOutputStream(bos);

        UserInfo2 u1 = new UserInfo2("JavaMan", "1234", 30);
        UserInfo2 u2 = new UserInfo2("JavaWoman", "4321", 26);

        ArrayList<UserInfo2> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);

        out.writeObject(u1);
        out.writeObject(u2);
        out.writeObject(list);

        out.close();
    }
}
