package com.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/29 23:05
 *
 * 获取Stream流的方式
 */
public class StreamGetter02 {
    public static void main(String[] args) {
        //1. 单列集合 获取集合的Stream流 调Stream方法
        Collection<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();


        //2.Map集合调Stream流 先获取键流值流 变成单列集合
        Map<String,Integer> map = new HashMap<>();
        Stream<String> s2 = map.keySet().stream();
        Stream<Integer> s3 = map.values().stream();
        //也可获取键值对流
        Stream<Map.Entry<String,Integer>> s4 = map.entrySet().stream();

        //3.获取数组流
        String[] names = {"Tom", "Jerry","Susan"};
        Stream<String> s5 = Arrays.stream(names);
        System.out.println(s5.count());

        //可以传入可变参数
        Stream<String> s6 = Stream.of(names);
        Stream<String> s7 = Stream.of("Tom", "Jerry", "Susan");
    }
}
