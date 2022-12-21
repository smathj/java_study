package com.java.study.fire.iostream.filterStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataFilterOutputStream {
    public static void main(String[] args) {
        // 필터스트림 Data[ In / Out ]Stream
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat"))) {
            out.writeInt(370);  // int형  데이터 저장
            out.writeDouble(3.14);  // double형 데이터 저장

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
