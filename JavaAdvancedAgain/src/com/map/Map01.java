package com.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/27 21:49
 *
 * HashMap 无序 不重复 无索引 键值对都可以是null 值不做要求（可以重复）
 * LinkedHashMap 有序 不重复 无索引 键值对都可以是null 值不做要求 Entry混合类型 双链表数据结构所以有序
 * TreeMap  按照键可排序 不重复 无索引 还是有自带比较器
 *
 * 存一一对应的键值对数据
 */
public class Map01 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",4);
        map.put("b",2);
        map.put("c",6);
        map.put("a",4);
        map.put("e",5);
        map.put(null,null);
        System.out.println(map);


        Map<String,Integer> map1 = new LinkedHashMap<>();
        map1.put("a",4);
        map1.put("b",2);
        map1.put("c",6);
        map1.put("a",4);
        map1.put("e",5);
        map1.put("a",4);
        System.out.println(map1);
    }
}
