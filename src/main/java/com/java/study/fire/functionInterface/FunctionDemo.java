package com.java.study.fire.functionInterface;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        //      파라미터타입, 리턴타입
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("가나다"));
        System.out.println(f.apply("13205461324"));


        Function<Map<String, String>, List<String>> fun = map -> new ArrayList<>(map.keySet());
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("김밥", "김밥");
        dataMap.put("선망", "선망");
        List<String> apply = fun.apply(dataMap);
        System.out.println("apply = " + apply);
    }
}
