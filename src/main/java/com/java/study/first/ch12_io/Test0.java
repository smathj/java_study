package com.java.study.first.ch12_io;

import java.util.Enumeration;
import java.util.Properties;

public class Test0 {
    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Properties properties = System.getProperties();

        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement().toString();
            String value = properties.getProperty(key);
            System.out.println(key + " : "+ value);

            // path.separator : ;
        }




    }
}
