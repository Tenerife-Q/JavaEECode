package com.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Tenerife
 * Su san
 * @date 2025/10/31 20:10
 *
 * Collections 常用静态方法
 */
public class Collections_ {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("Tom");
//        list.add("Jerry");
//        list.add("Susan");
//        list.add("Tenerife");
//        list.add("Luka");
//        list.add("Trump");
//        list.add("Jack");

        Collections.addAll(list,"Tom","Jerry","Susan","Tenerife");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }
}
