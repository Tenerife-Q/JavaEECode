package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/29 22:04
 *
 * Stream流作为结合Lambda表达式简化操作的API
 *
 * 1.准备数据源
 * 2.调用流水线各种方法 对数据进行处理计算
 * 3.获取处理的结果 遍历 统计 收集到一个新集合中返回
 */
public class Stream01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tenrife");
        list.add("Barcelona");
        list.add("Su san");
        list.add("qinzi");
        list.add("TenerifeSea");

        //1.
        List<String> list2 = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("Ten")&&name.length()>3){
                list2.add(name);
            }
        }
        System.out.println(list2);

        //2.Stream
        List<String> newList = list.stream().filter(s -> s.startsWith("Ten")).filter(s -> s.length()>3).collect(Collectors.toList());
        System.out.println(newList);
    }
}
