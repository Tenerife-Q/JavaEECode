package com.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 21:34
 *
 * 下面开始了解Set
 * Set接口中方法大多来自父接口Colllection 也包装了Map中的原理 只是取了键没取值
 *
 * HashSet集合 无序 无索引 不重复           包装了HashMap原理
 * LinkedHashSet集合 有序 不重复 无索引     包装了LinkedHashMap原理
 * TreeSet集合排序（默认升序） 不重复  无索引 包装了TreeMap原理
 */
public class Set01 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();//经典代码
        hs.add("java");
        hs.add("java");
        hs.add("javaScript");
        hs.add("go");
        hs.add("golang");
        hs.add("c++");
        hs.add("c");
        hs.add("solidity");
        hs.add("rust");
        System.out.println(hs);



        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("java");
        lhs.add("java");
        lhs.add("javaScript");
        lhs.add("go");
        lhs.add("golang");
        lhs.add("c++");
        lhs.add("c");
        lhs.add("solidity");
        lhs.add("rust");
        System.out.println(lhs);



        Set<Double> ts = new TreeSet<>();
        ts.add(3.14);
        ts.add(6.5);
        ts.add(2.0);
        ts.add(4.0);
        System.out.println(ts);

        System.out.println("=================================");

        /*
        HashSet集合底层原理 数组+链表+红黑树
        链表长度>8 数组长度 >= 64 就转红黑树
         */

    }
}
