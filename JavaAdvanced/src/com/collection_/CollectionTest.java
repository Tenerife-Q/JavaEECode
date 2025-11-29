package com.collection_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 16:34
 *
 * 认识并发修改异常问题，弄清楚每种遍历区别
 * 需求：删除所有包含java的元素
 */
public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("javagolang");
        list1.add("c");
        list1.add("c++");
        list1.add("python");
        list1.add("javaScript");
        list1.add("javarust");
        list1.add("solidity");
        System.out.println(list1);


        for (int i = 0; i < list1.size(); i++) {//list1.fori
            String name = list1.get(i);
            if(name.contains("java")){
                list1.remove(name);
                i--;//detail:如果没有这行 就会漏删 因为remove过后面会自动往前补 如果i不回退 就会造成两个连续包含java的第二个漏删
            }
        }
        System.out.println(list1);


        System.out.println("====================================================");


        ArrayList<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("javagolang");
        list2.add("c");
        list2.add("c++");
        list2.add("python");
        list2.add("javaScript");
        list2.add("javarust");
        list2.add("solidity");
        System.out.println(list2);


        //从后往前就不用回退i 没有删除并发问题
        for (int i = list2.size() - 1; i >= 0; i--) {
            String name = list2.get(i);
            if(name.contains("java")){
                list2.remove(name);
            }
        }
        System.out.println(list2);

        System.out.println("===============================================");


        ArrayList<String> list3 = new ArrayList<>();
        list3.add("java");
        list3.add("javagolang");
        list3.add("c");
        list3.add("c++");
        list3.add("python");
        list3.add("javaScript");
        list3.add("javarust");
        list3.add("solidity");
        System.out.println(list3);

        //1. 迭代器 如果有索引的集合可以使用上述两种 没有索引只能使用迭代器
        Iterator<String> it = list3.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if(name.contains("java")){
                it.remove();//可以调用迭代器自己的remove 是考虑到这个问题了的
                list3.remove(name);//不能集合调用remove，存在并发删除异常(ConcurrentModificationException) 详见源码remove()
            }
        }
        System.out.println(list3);

        System.out.println("===================================================");


        ArrayList<String> list4 = new ArrayList<>();
        list4.add("java");
        list4.add("javagolang");
        list4.add("c");
        list4.add("c++");
        list4.add("python");
        list4.add("javaScript");
        list4.add("javarust");
        list4.add("solidity");
        System.out.println(list4);

        //2. 增强for forEach()解决不了 只适合遍历因为遍历更加简单 不适合遍历并发删除

//        for (String s : list4) {
//            if(s.contains("java")){
//                list4.remove(s);
//            }
//        }
//        System.out.println(list4);


        //list4.forEach(System.out::println);
    }
}
