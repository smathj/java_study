package com.java.study.standard.ch16_network;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient5 {

    public static void main(String[] args) {

        try {
            String serverIp = "127.0.0.1";
            Socket socket = new Socket(serverIp, 7777);

            System.out.println("서버에 연결되었습니다" + serverIp + ":" + socket.getPort());
            Sender sender = new Sender(socket);         // DataOutputStream
            Receiver receiver = new Receiver(socket);   // DataInputStream

            sender.start();
            receiver.start();

        } catch (ConnectException ce) {
            ce.printStackTrace();

        } catch (IOException ie) {
            ie.printStackTrace();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
