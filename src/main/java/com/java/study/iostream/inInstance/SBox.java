package com.java.study.iostream.inInstance;

import java.io.Serializable;

public class SBox implements Serializable {
    String s;

    public SBox(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }
}
