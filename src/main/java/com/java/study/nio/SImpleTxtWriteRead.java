package com.java.study.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SImpleTxtWriteRead {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("C:\\java_workspace\\java_study\\java_study\\src\\main\\java\\com\\java\\study\\nio\\empty2.txt");

        String st1 = "제대로된 회사 가고싶다";
        String st2 = "항상 역피라미드에 노답 좆소";
        List<String> lst1 = Arrays.asList(st1, st2);

        Files.write(fp, lst1);  // 파일에 문자열 저장하기
        List<String> lst2 = Files.readAllLines(fp);// 파일로부터 문자열 읽기
        System.out.println(lst2);


    }
}
