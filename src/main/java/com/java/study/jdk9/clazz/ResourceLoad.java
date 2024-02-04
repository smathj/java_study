package com.java.study.jdk9.clazz;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class ResourceLoad {

    public static void main(String[] args) throws IOException {

        InputStream stream = ResourceLoad.class.getResourceAsStream("1.txt");

        System.out.println("stream = " + stream);


    }
}
