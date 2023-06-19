package com.java.study.god.collection.map;

import java.util.LinkedHashMap;

public class Map03 {

    public static void main(String[] args) {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "111");
        linkedHashMap.put("b", "222");
        linkedHashMap.put("c", "333");

        System.out.println("linkedHashMap = " + linkedHashMap);



    }
}
