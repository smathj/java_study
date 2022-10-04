package com.java.study.nested.lamda;

interface Printable {
    void print(String s);
}

public class Labmda4 {
    public static void ShowString(Printable p, String s) {
        p.print(s);
    }

    public static void main(String[] args) {
        ShowString((s) -> { System.out.println(s); }, "What is Lambda?");
    }
}
