package com.java.study.god.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map01 {

    public static void main(String[] args) {

        Map<String, Object> dataMap = new HashMap<>();


        dataMap.put("키", "값");

        Set<Map.Entry<String, Object>> entries = dataMap.entrySet();
        System.out.println("entries = " + entries);
        int size = entries.size();
        System.out.println("size = " + size);
        entries.forEach((obj) -> {
            String key = obj.getKey();
            String value = String.valueOf(obj.getValue());

            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });

        Map<String, Object> stringObjectMap = Collections.synchronizedMap(dataMap);
        System.out.println("stringObjectMap = " + stringObjectMap);

    }
}
