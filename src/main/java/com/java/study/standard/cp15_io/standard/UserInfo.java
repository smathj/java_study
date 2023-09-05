package com.java.study.standard.cp15_io.standard;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private String name;
    private String password;

    private int age;

    public UserInfo() {
        this("Unknown", "1111", 0);
    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String toString() {
        return "(" + name + "," + password + "," + age + ")";
    }
}
