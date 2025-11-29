package com.collection_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 14:45
 *
 * collection 单列集合
 * Map 双列集合
 *
 * 下面是collection集合的两大体系
 */
public class Collection01 {
    public static void main(String[] args) {
        //List 集合 有序 可重复 有索引
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("B");
        list.add("C");
        System.out.println(list);
        String s1 = list.get(0);
        System.out.println(s1);

        //Set集合 无序 不可重复 无索引
        Set<String> set = new HashSet<>();
        set.add("javaScript");
        set.add("C");
        set.add("java");
        set.add("java");
        set.add("C++");
        System.out.println(set);
    }
}
