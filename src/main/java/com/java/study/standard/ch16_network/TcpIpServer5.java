package com.java.study.standard.ch16_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {

            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다 127.0.0.1:" + serverSocket.getLocalPort());

            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();     // DataOutputStream
            receiver.start();   // DataInputStream


        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
class Sender extends Thread {

    Socket socket;
    DataOutputStream out;
    String name;

    public Sender(Socket socket) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (out != null) {
            try {
                out.writeUTF(name + scanner.nextLine());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
//        super.run();
    }
}

class Receiver extends Thread {

    Socket socket;
    DataInputStream in;

    public Receiver(Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (in != null) {
            try {
                System.out.println(in.readUTF());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

//        super.run();
    }
}