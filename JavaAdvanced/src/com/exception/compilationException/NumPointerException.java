package com.exception.compilationException;

/**
 * @author Tenerife
 * Su san
 */
public class NumPointerException {
    public static void main(String[] args) {
        String name = null;
        //空指针异常
        System.out.println(name.length());
    }
}
