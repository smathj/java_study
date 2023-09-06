package com.java.study.standard.ch16_network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {

    public static void main(String[] args) {

        InetAddress ip = null;
        InetAddress[] ipArr = null;


        try {
            ip = InetAddress.getByName("fpbc.nongsu.co.kr");// host

            System.out.println("ip.getHostName() = " + ip.getHostName());
            System.out.println("ipArr = " + ip.getHostAddress());
            System.out.println("ip.toString() = " + ip.toString());

            byte[] ipAddr = ip.getAddress();    // ip를 byte로 리턴
            System.out.println("ip.getAddress() = " + Arrays.toString(ipAddr));

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }

            System.out.println("ip.getAddress() + 256 = " + result);


        } catch(UnknownHostException e) {
            e.printStackTrace();
        }


        try {
            ip = InetAddress.getLocalHost();
            System.out.println("ip.getHostName() = " + ip.getHostName());
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress());
            System.out.println();
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }


        try {
            ipArr = InetAddress.getAllByName("fpbc.nongsu.co.kr");
            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" +i + "] = " + ipArr[i]);

            }
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
