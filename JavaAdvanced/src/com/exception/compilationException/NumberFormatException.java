package com.exception.compilationException;

/**
 * @author Tenerife
 * Su san
 */
public class NumberFormatException {
    public static void main(String[] args) {
        String name = "Tenerife";

        //字符串不能转换为相应格式，抛出该异常
        int num = Integer.parseInt(name);
        System.out.println(num);
    }
}
