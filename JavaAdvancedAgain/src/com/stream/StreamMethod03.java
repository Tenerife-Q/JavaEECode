package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/29 23:23
 *
 * 掌握Stream流提供的中间方法，对流上数据进行处理
 * 会返回新的流Stream(T) 后面接着用
 * 为了展示输出 所以以下所有中间方法都只调用了.forEach()的终结方法
 */
public class StreamMethod03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Susan");
        list.add("Tenerife");
        list.add("Luka");
        list.add("Trump");

        //1. 过滤方法
        list.stream().filter(s -> s.startsWith("T") && s.length() == 3).forEach(s -> System.out.println(s));

        //2. 排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(1.0);
        scores.add(6.1);
        scores.add(9.6);
        scores.add(0.4);
        scores.add(11.5);
        scores.add(1.0);

        System.out.println("=============默认升序==============");
        scores.stream().sorted().forEach(System.out::println);//默认升序
        System.out.println("===============自定义方法降序===============");
        scores.stream().sorted((a,b) -> Double.compare(b,a)).forEach(System.out::println);
        System.out.println("===============限制前三个===============");
        scores.stream().sorted().limit(3).forEach(sout -> System.out.println(sout));
        System.out.println("==============跳过前三名================");
        scores.stream().sorted().skip(3).forEach(s -> System.out.println(s));
        System.out.println("================去重distinct()==============");
        //如果希望自定义对象能够去重复，需要重写对象的HashCode equals方法
        scores.stream().sorted((a,b) -> Double.compare(b,a)).distinct().forEach(s -> System.out.println(s));


        System.out.println("================映射加工方法 把流上原来的数据拿出来变成新数据===============");
        scores.stream().map(s -> "After plus ten points: " + (s+10)).forEach(s -> System.out.println(s));

        System.out.println("===============合并流 每次只能合并两个================");
        Stream<String> s1 = Stream.of("Tom", "Jerry", "Susan", "Tenerife", "Luka", "Trump");
        Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Object> s3 = Stream.concat(s1, s2);

        System.out.println(s3.count());
    }
}
