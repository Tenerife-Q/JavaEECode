package com.wrapper;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 20:50
 */


public class WrapperSwapString {
    public static void main(String[] args) {
        //Integer -> String
        Integer i = 100;
        String str1 = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);

        //String -> Integer
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//自动装箱
        Integer i3 = new Integer(str4);
    }
}
