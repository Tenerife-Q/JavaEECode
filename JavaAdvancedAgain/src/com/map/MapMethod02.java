package com.map;

import java.util.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 22:11
 *
 * Map 常用方法
 */
public class MapMethod02 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",7);
        map.put("c",5);
        map.put("d",4);
        map.put("a",1);
        map.put("f",7);
        System.out.println(map);

        System.out.println(map.get("a"));
        System.out.println(map.get("e"));

        System.out.println(map.containsKey("b"));
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(8));

        System.out.println(map.remove("c"));
        System.out.println(map);

//        map.clear();
//        System.out.println(map);

        System.out.println(map.isEmpty());

        System.out.println(map.size());


        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }


        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
