package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/20 14:37
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        //1. 返回数组的字符串形式 源码 [1,20,90]
        Integer[] integers = {1,20,90};
        System.out.println(Arrays.toString(integers));

        //2. sort排序
        //因为数组是引用类型，所以sort排序后会直接影响到实参arr
        Integer[] arr = {1,-1,7,0,89};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });


        //sort重载 传入一个匿名内部类接口Comparator 实现定制排序compare方法
        //具体看源码
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object o1,Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i1 - i2;
            }
        });
    }
}
