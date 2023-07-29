package com.java.study.master.ch5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample4 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("cccc");
        list.add("ddddd");

        Map<Integer, List<String>> map = new HashMap<>();

        list.forEach(name -> {
            Integer nameLen = name.length();

            // 키가 없을 때만, 빈 List를 값으로 부여한다
            List<String> valueList = map.computeIfAbsent(nameLen, key -> new ArrayList<>());

            valueList.add(name);
//            System.out.println("valueList = " + valueList);

        });

        System.out.println(map);


    }
}
