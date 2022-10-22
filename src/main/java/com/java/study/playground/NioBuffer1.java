package com.java.study.playground;

import java.nio.ByteBuffer;

public class NioBuffer1 {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(10);

        System.out.println("position[" + buf.position() +"] Limit["+ buf.limit()+"] Capacity["+buf.capacity()+"]" );

        buf.mark(); //나중에 찾아 오기 위해 현재 위치를 지정해 둔다. (현재 위치는 0 )

        // 순차적으로 데이터 넣기 -> 데이터를 넣을 때 마다 position이 바뀐다.
         buf.put((byte)10);
         System.out.println("put result -> position[" + buf.position() +"]");
         buf.put((byte)11);
         System.out.println("put result -> position[" + buf.position() +"]");
         buf.put((byte)12);
         System.out.println("put result -> position[" + buf.position() +"]");

         //mark 해 두었던 위치로 이동
         buf.reset();
         System.out.println("put reset -> position[" + buf.position() +"]");
         System.out.println("");
         System.out.println("데이터 들어간 결과 확인");


        // 데이터를 get 할 때 마다 position이 바뀐다.
         for( int i = 0 ; i < 5 ; i++ ) {
            System.out.println("position[" + buf.position() +"] value["+ buf.get() + "]");
         }


        // 지정한 위치에 데이터에 넣기
         buf.put(2, (byte)22);
         buf.put(3, (byte)23);
         buf.put(4, (byte)24);

         System.out.println("");
         System.out.println("데이터 들어간 결과 확인");

         for( int i = 0 ; i < 10 ; i++ ) {
            System.out.println("position[" + i +"] value["+ buf.get(i) + "]");
         }
    }
}

