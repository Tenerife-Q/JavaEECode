package com.exception.compilationException;

/**
 * @author Tenerife
 * Su san
 */

//ctrl + alt + t -> try-catch
    //e.getMessage()返回异常信息
public class ArithmeticException {
    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 0;

        int res = n1 / n2;
        //异常运算条件时抛出此异常
        System.out.println(res);
    }
}
