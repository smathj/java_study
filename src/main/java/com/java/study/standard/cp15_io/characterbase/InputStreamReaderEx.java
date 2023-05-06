package com.java.study.standard.cp15_io.characterbase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class InputStreamReaderEx {
    public static void main(String[] args) {

        Properties prop = System.getProperties();
        String encoding = (String) prop.get("sun.jnu.encoding");
        System.out.println("encoding = " + encoding);

        String line = "";
        try {

            InputStreamReader isr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("사용중인 OS 인코딩 : " + isr.getEncoding());
            
            do {
                System.out.print("문장을 입력하세요. 마치시려면 q를 입력하세요.>");
                line = br.readLine();
                System.out.println("입력하신 문장 : " + line);
            } while(!line.equalsIgnoreCase("q"));

            
//            br.close();   // System.in과 같은 표준입출력은 닫지 않아도 된다
            System.out.println("프로그램을 종료합니다");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
