package com.java.study.standard.cp15_io.standard;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {

    public static void main(String[] args) throws Exception {

        String fileName = "UserInfo.ser";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        ObjectInputStream in = new ObjectInputStream(bis);

        UserInfo u1 = (UserInfo) in.readObject();
        UserInfo u2 =  (UserInfo) in.readObject();

        ArrayList<UserInfo> list = (ArrayList<UserInfo>) in.readObject();

        System.out.println("u1 = " + u1);
        System.out.println("u2 = " + u2);
        System.out.println("list = " + list);

        in.close();
    }
}
