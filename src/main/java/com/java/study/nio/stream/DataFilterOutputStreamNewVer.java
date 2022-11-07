package com.java.study.nio.stream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFilterOutputStreamNewVer {
    public static void main(String[] args) throws IOException {

//        Path fp = Paths.get("data.dat");
        Path fp = Paths.get("");

        // 현재클래스가 있는 디렉토리 위치에 파일 생성 하려면 ?
        Class<DataFilterOutputStreamNewVer> myClass = DataFilterOutputStreamNewVer.class;
        String thisPath = "src\\main\\java\\" + (myClass.getPackage().toString().split(" "))[1].replace(".", "\\");


        String prefix = fp.toAbsolutePath().toString();
        String fullPath = prefix + "\\" + thisPath + "\\yosi.dat";

        Path path = Paths.get(fullPath);

//        try(DataOutputStream out = new DataOutputStream(Files.newOutputStream(fp))) {
        try(DataOutputStream out = new DataOutputStream(Files.newOutputStream(path))) {
            out.writeInt(370);
            out.writeDouble(3.14);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
