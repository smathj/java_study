package com.java.study.first.reg;

import java.util.regex.Pattern;

public class Reg01 {
    public static void main(String[] args) {


        // * 첫문자는 A ~ Z 사이의 한글자
        // * 두번째 문자부터 a~z ㄸ는 A~Z사이의 문자가 0개이상
        boolean test1 = Pattern.matches("[A-Z][a-zA-Z]*", "Apple");
        System.out.println("test1 = " + test1);




        // * 시작하는 문자는 알파벳 1개 이상
        // * 다음에는 '나 -가 한번 나오고, 알파벳은 1번이상오는  <- 이게 하나의 그륩으로 0번이상 나온다
        boolean test2 = Pattern.matches("[a-zA-Z]+(['-][a-zA-Z]+)*", "Apple's");
        System.out.println("test2 = " + test2);

        boolean test3 = Pattern.matches("[a-zA-Z]+(['-][a-zA-Z]+)*", "Apple-Tea");
        System.out.println("test3 = " + test3);



        // * 첫문자는 ' 또는 - 가 나올수 있고
        // * 두번째 문자부터는 알파벳이 1개이상 올수 있다
        boolean test4 = Pattern.matches("['-][a-zA-Z]+", "-Hello");
        System.out.println("test4 = " + test4);

        boolean test5 = Pattern.matches("['-][a-zA-Z]+", "'this");
        System.out.println("test5 = " + test5);



        // * 핸드폰
        boolean test6 = Pattern.matches("01[0-9]-\\d{3,4}-\\d{4}", "010-1234-5678");
        System.out.println("test6 = " + test6);


        // * 이메일
        boolean test7 = Pattern.matches("^\\w+@\\w+(\\.\\w+){1,2}$", "blatrem@naver.com");
        System.out.println("test7 = " + test7);

        boolean test8 = Pattern.matches("\\w+@\\w+(\\.\\w+){1,2}", "smathj@natae.co.kr");
        System.out.println("test8 = " + test8);


        // * 주민등록번호 123456-1234567 6자리, 7자리
        boolean test9 = Pattern.matches("\\d{2}[0-1][0-9][0-3][0-9]-[1-4]\\d{6}", "123456-1234567");
        System.out.println("test9 = " + test9);

        boolean test10 = Pattern.matches("\\d{6}-[1-4]\\d{6}", "123456-1234567");
        System.out.println("test10 = " + test10);
    }
}
