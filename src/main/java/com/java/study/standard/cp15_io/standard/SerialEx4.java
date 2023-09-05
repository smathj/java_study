package com.java.study.standard.cp15_io.standard;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx4 {

    public static void main(String[] args) throws Exception {

        String fileName = "UserInfo2.ser";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);

        ObjectInputStream in = new ObjectInputStream(bis);

        UserInfo2 u1 = (UserInfo2) in.readObject();
        UserInfo2 u2 =  (UserInfo2) in.readObject();

        ArrayList<UserInfo2> list = (ArrayList<UserInfo2>) in.readObject();

        System.out.println("u1 = " + u1);
        System.out.println("u2 = " + u2);
        System.out.println("list = " + list);

        in.close();
    }
}
