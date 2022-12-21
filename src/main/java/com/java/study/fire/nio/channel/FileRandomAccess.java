package com.java.study.fire.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileRandomAccess {
    public static void main(String[] args) {

        Path fp = Paths.get("data.dat");

        // ! 버퍼 생성 ( 첫번째 버퍼 )
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);  // 10kb

        // 버퍼에 데이터 저장
        writeBuffer.putInt(120); // int형 데이터 저장                 포지션4
        writeBuffer.putInt(240); //                                 포지션8
        writeBuffer.putDouble(0.94); // double형 데이터 저장
        writeBuffer.putDouble(0.75);

        // 하나의 채널 생성 (만들기,읽기,쓰기 다됨!)
        try(FileChannel fileChannel = FileChannel.open(fp, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE)) {

            // 파일에 쓰기
            writeBuffer.flip();  // 버퍼를 읽을 수 있게 변환, 포지션 0
            fileChannel.write(writeBuffer);

            // ! 파일로부터 읽기 ( 두번째 버퍼 )
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);  // 버퍼 생성
            fileChannel.position(0); // ! 채널의 포지션을 맨 앞으로 이동, 쓸대 제일 뒤로 가버렷기때문에 돌려줌, 채널또한 포지션 개념을 사용하기때문에
            fileChannel.read(readBuffer);

            // 이하 버퍼로부터 데이터 읽기
            readBuffer.flip();  // 버퍼를 읽을 수 있게 변환, 버퍼의 포지션 0
            System.out.println(readBuffer.getInt());
            readBuffer.position(Integer.BYTES * 2); // ! 버퍼의 포지션 이동
            System.out.println(readBuffer.getDouble());
            System.out.println(readBuffer.getDouble());

            readBuffer.position(Integer.BYTES * 2); // ! 버퍼의 포지션 이동
            System.out.println(readBuffer.getInt());

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
