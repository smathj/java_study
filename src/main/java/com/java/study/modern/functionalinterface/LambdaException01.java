package com.java.study.modern.functionalinterface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface StringFunction {
    int length(String param) throws Exception;
}

public class LambdaException01 {
    public static void main(String[] args) {
        try {
            List<String> list = Arrays.asList("ㅁ", "ㅁㅁㄴㅇ", "ㅁㅍㅋㅋ", "ㅁㅂㅈㄷㅁㄴㄹ");
            int maxLength = LambdaException01.getMaxLength(list, (String word) -> word.length());
            System.out.println("maxLength = " + maxLength);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> int getMaxLength(List<T> list, StringFunction f) throws Exception {
        try {
            int max = f.length((String) list.get(0));
            for (T t : list) {
                int nowNum = f.length((String) t);
                if (nowNum > max) {
                    max = nowNum;
                }
            }
            return max;
        } catch (RuntimeException e) {
            throw new RuntimeException("에러");
        }
    }
}
