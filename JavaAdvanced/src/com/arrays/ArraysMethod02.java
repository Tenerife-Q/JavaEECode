package com.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/20 16:46
 */
public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,90,123,567};

        //binarySearch二叉查找
        //要求数组有序 无序不行 不存在就返回 return -(low + 1)
        int index1 = Arrays.binarySearch(arr,90);
        int index2 = Arrays.binarySearch(arr,456);//low = 456应该存在在数组中索引  -(4 + 1)
        System.out.println(index1 + " " + index2);

        //copyOf 数组元素复制
        //从arr数组拷贝arr.length个元素到newArr数组
        Integer[] newArr1 = Arrays.copyOf(arr,arr.length);
        Integer[] newArr2 = Arrays.copyOf(arr,arr.length + 1);
        Integer[] newArr3 = Arrays.copyOf(arr,arr.length - 1);
        Integer[] newArr4 = Arrays.copyOf(arr,0);
        System.out.println(Arrays.toString(newArr1));
        System.out.println(Arrays.toString(newArr2));
        System.out.println(Arrays.toString(newArr3));
        System.out.println(Arrays.toString(newArr4));


        //fill 数组填充 替换所有元素
        Integer[] num = new Integer[]{9,3,2};
        Arrays.fill(num,9);
        System.out.println(Arrays.toString(num));


        //equals 比较两个数组内容是否完全一致
        //只要不是完全一样就返回false
        Integer[] arr2 = {2,3,4,5};
        boolean equals = Arrays.equals(arr,arr2);
        System.out.println("equals =  " + equals);


        //asList 将一组值转换成List集合
        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList =" + asList);
        System.out.println(Arrays.toString(asList.toArray()));
        System.out.println(asList.toArray());//Object[] 的默认 toString() 并不会打印元素，而是打印类名和哈希码，
        //说明asList.toArray()返回的是Object类型 但这两个基本不会这么使用
        System.out.println("asList运行类型 =" + asList.getClass());
    }
}
