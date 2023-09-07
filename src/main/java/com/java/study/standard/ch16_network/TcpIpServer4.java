package com.java.study.standard.ch16_network;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable {

    ServerSocket serverSocket;
    Thread[] threadArr;


    public static void main(String[] args) {

        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();

    }


    public TcpIpServer4(int num) {
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다");

            threadArr = new Thread[num];

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void start() {
        for (int i = 0; i < threadArr.length; i++) {
            Thread thread = threadArr[i];
            thread.start();
        }
    }

    public void run() {
        while (true) {

            try {
                System.out.println(getTime() + "연결 요청을 기다립니다");

                serverSocket.setSoTimeout(5 * 1000);

                Socket socket = serverSocket.accept();

                System.out.println(getTime() + socket.getInetAddress() + "로 부터 연결요청이 들어왔습니다");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓에 데이터를 보낸다
                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime() + " 데이터를 전송 했습니다");

                dos.close();
                socket.close();

            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[hh:mm:ss]");
        return simpleDateFormat.format(new Date());
    }
}
