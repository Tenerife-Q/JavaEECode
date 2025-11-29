package com.string;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 13:29
 */
public class String01 {
    public static void main(String[] args) {
        /*
        1. 字符串字符适用Unicode编码，一个字符占两个字节
        2. String类有很多构造器，构造器的重载 常用的有
            String s1 = new String;
            String s2 = new String(String original);
            String s3 = new String(char[] a);
            String s4 = new String(char[] a, int starIndex, int count)
            String s5 = new String(byte[] b)
        3. String 类实现了接口Serializable 可以让String串行化 即可在网络传输
                         接口Comparable 可以让String对象比较大小
        4. String类是final类 不能被其他类继承
        5. String类有属性private final char value[]; 用于存放字符串内容
        6. value 是一个final 类型 即value不能指向新的地址，但可以改变单个字符串内容
         */

        String name  = "Tenerife";
        name = "Su san";

        final char[] value = {'a','b','c'};

        char[] v2 = {'d','e','f','g','h'};

        value[0] = 'g';

        //value = v2;   Cannot assign a value to final variable 'value'
    }
}
