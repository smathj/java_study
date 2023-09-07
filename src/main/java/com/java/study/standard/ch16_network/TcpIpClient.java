package com.java.study.standard.ch16_network;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpClient {

    public static void main(String[] args) {

        try {

            String serverIp = "127.0.0.1";
            int port = 7777;

            System.out.println("서버에 연결중입니다");
            System.out.println("ip : " + serverIp);
            System.out.println("port : " + port);

            Socket socket = new Socket(serverIp, port);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            String read = dis.readUTF();
            System.out.println("서버로부터 받은 메세지 : "+ read);
            System.out.println("연결을 종료합니다");

            dis.close();
            socket.close();

            System.out.println("연결이 종료 되었습니다");

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[hh:mm:ss]");
        return simpleDateFormat.format(new Date());
    }
}
