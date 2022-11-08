package com.java.study.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileCopierVerNIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 파일 : ");
        Path src = Paths.get(sc.nextLine());

        System.out.print("사본 이름 :");
        Path dst = Paths.get(sc.nextLine());

        // 하나의 버퍼 생성
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // try에서 두개의 채널 생성한다
        try (
                // 읽기용 채널
                FileChannel ifc = FileChannel.open(src, StandardOpenOption.READ);   // 읽기
                // 입력용 채널
                FileChannel ofc = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE);   // 쓰기, 파일이 존재하지 않으면 생성
        ) {
            int num;
            while (true) {
                num = ifc.read(buf);    // 채널 ifc에서 버퍼로 읽어 들인다
                if (num == -1) {
                    break;
                }
                // 이걸 모드변경안하면 0000 으로 나오누 못읽어서
                buf.flip(); // 모드 변환, 버퍼에 저장된 데이터를 읽을 수 있는 상태로 변경하는 것
                ofc.write(buf); // 버퍼에서 채널 ofc로 데이터 전송
                buf.clear();    // 버퍼 지우기
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
