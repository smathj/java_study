package com.java.study.standard.ch16_network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdoClient {

    public void start() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        byte[] msg = new byte[100];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);

        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket);
        datagramSocket.receive(inPacket);

        System.out.println("current server time :" + new String(inPacket.getData()));

        datagramSocket.close();
    }

    public static void main(String[] args) throws IOException {
            try {
                new UdoClient().start();
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
}
