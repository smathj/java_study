package com.java.study.stream.stream_05;

import java.util.stream.IntStream;

class LazyOpStream {
    public static void main(String[] args) {
        // ���� ������ ������ ��Ʈ���� ����������
        IntStream.of(1, 3, 5)
            .peek(d -> System.out.print(d + "\t"));
        System.out.println();

  
        // ���� ������ �����ϴ� ��Ʈ���� ����������
        IntStream.of(5, 3, 1)
            .peek(d -> System.out.print(d + "\t"))
            .sum();            
        System.out.println();
    }
}