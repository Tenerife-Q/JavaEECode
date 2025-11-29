package com.collection_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 14:56
 *
 * Collection通用功能
 */
public class Collection02 {
    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();//多态
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);


        System.out.println(list.size());


        list.remove("a");
        System.out.println(list);


        System.out.println(list.isEmpty());


        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());


        System.out.println(list.contains("a"));


        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));

    }
}
