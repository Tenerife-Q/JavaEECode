package com.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 19:07
 *
 * 收集操作 终结方法 流不再可被使用
 */
public class StreamCollect04 {
    public static void main(String[] args) {

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Tenerife",19,102233));
        teachers.add(new Teacher("Su san",18,9600));
        teachers.add(new Teacher("Su",19,7600));
        teachers.add(new Teacher("qinzi",17,6600));

        System.out.println("=============================================================================");

        teachers.stream().filter(t -> t.getSalary() > 8000).forEach(System.out::println);

        System.out.println("=============================================================================");

        long count = teachers.stream().filter(t -> t.getSalary() > 8000).count();
        System.out.println(count);

        System.out.println("============================================================================");

        Optional<Teacher> max = teachers.stream().max((t1,t2) -> Double.compare(t1.getSalary(),t2.getSalary()));
        System.out.println(max.get());

        Optional<Teacher> min = teachers.stream().min((t1,t2) -> Double.compare(t1.getSalary(),t2.getSalary()));
        Teacher minTeacher = min.get();
        System.out.println(minTeacher);



        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Susan");
        list.add("Tenerife");
        list.add("Luka");
        list.add("Trump");

        //收集到集合数组中去 且流只能被收集一次
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("T"));
        List<String> list1 = s1.collect(Collectors.toList());
        System.out.println(list1);

        Stream<String> s2 = list.stream().filter(s -> s.startsWith("S"));
        Set<String> set = s2.collect(Collectors.toSet());
        System.out.println(set);

        //数组
        Stream<String> s3 = list.stream().filter(s -> s.startsWith("T"));
        Object[] arr = s3.toArray();
        System.out.println(Arrays.toString(arr));

        //Map
        Map<String, Double> map = teachers.stream().collect(Collectors.toMap(Teacher::getName, t -> t.getSalary()));
        System.out.println(map);
    }
}
