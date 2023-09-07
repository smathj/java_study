package com.java.study.standard.ch16_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx4 {

    public static void main(String[] args) {

        URL url = null;
        String address = "https://fpbc.nongsu.co.kr/";

        BufferedReader input = null;
        String line = "";

        try {

            url = new URL(address);
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();


        } catch (Exception e) {

        }

    }
}
