package com.java.study.jdk9.io;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MemoryMap {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("src/main/java/com/java/study/jdk9/io/story.txt");


        // 메모리에 전체 로드
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);

        // 다향성으로 ByteBuffer
        ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());


        byte b = buffer.get();
        System.out.println("b = " + b);

        channel.close();




    }
}
