package com.file_;

import java.util.Arrays;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 15:46
 *
 * 字符集 编码解码格式
 *
 * 解码编码格式要一致 否则会出现乱码
 * utf-8 汉字占三个字节  GBK 国标占2个字节
 */
public class CharSet {
    public static void main(String[] args) {

        String name = "覃冠三jdk11";//汉字二进制第一位是1 字节为负数

//        byte[] bytes = name.getBytes("GBK") 指定国标进行编码 但是需要抛出异常 只要输入编码格式正确就行
        byte[] bytes = name.getBytes();
        System.out.println(bytes.length);//字节个数
        System.out.println(Arrays.toString(bytes));

//        String name2 = new String(Bytes, "GBK"); 同样指定GBK进行解码
        String name2 = new String(bytes);
        System.out.println(name2);
    }
}
