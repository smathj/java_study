package com.java.study.god.collection.map;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class Map02 {

    public static void main(String[] args) {

        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("2", "두번째");
        treeMap.put("1", "첫번째");
        treeMap.put("나", "나비");
        treeMap.put("가", "가지");

        System.out.println("treeMap = " + treeMap);

        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println("key :" + entry.getKey() + ", value :" + entry.getValue());
        }
    }
}
