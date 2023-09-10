package com.java.study.standard.ch16_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {

    HashMap<String, DataOutputStream> clients;

    public TcpIpMultichatServer() {
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);   // 동기화
    }

    public static void main(String[] args) {
        new TcpIpMultichatServer().start();

    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속했습니다");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    void sendToAll(String msg) {

        Iterator<String> it = clients.keySet().iterator();

        while (it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());   // name -> DataOutputStream
                out.writeUTF(msg);
            } catch(Exception e) {
            }
        }

    }

    class ServerReceiver extends Thread {

        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch(Exception e) {
            }
        }

        @Override
        public void run() {
            String name = "";

            try {
                name = in.readUTF();
                sendToAll("#" + name + "님이 들어오셨습니다");

                clients.put(name, out);
                System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다");

                while (in != null) {
                    sendToAll(in.readUTF());    // 클라이언트에게 전송
                }
            } catch(Exception e) {
            } finally {
                sendToAll("#" + name + "님이 나가셨습니다");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort()  +"]");
                System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다");
            }

        }
    }
}
