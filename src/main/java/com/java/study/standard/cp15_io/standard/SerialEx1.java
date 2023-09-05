package com.java.study.standard.cp15_io.standard;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {

    public static void main(String[] args) throws Exception {

        String fileName = "UserInfo.ser";
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        ObjectOutputStream out = new ObjectOutputStream(bos);

        UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
        UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);

        ArrayList<UserInfo> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);

        out.writeObject(u1);
        out.writeObject(u2);
        out.writeObject(list);
        out.close();
    }
}
