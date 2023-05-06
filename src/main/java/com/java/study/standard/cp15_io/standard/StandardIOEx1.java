package com.java.study.standard.cp15_io.standard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardIOEx1 {

    public static void main(String[] args) {

        try {

            String txt = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while ((txt = br.readLine()) != null) {
                System.out.println("txt = " + txt);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        /*
        try {
            int input = 0;

            while ((input = System.in.read()) != -1) {
                System.out.println("input = " + input + ", (char) input : " + (char) input);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        */
    }
}
