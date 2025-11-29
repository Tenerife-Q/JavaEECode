package com.exception.compilationException;

/**
 * @author Tenerife
 * Su san
 */
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //数组下标越界异常，非法索引访问数组，即索引为负或者大于等于数组长度
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
