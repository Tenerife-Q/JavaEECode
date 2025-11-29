package com.stringBuffer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 21:10
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        //增
        StringBuffer s = new StringBuffer("Tenerife");
        s.append("herewego").append("、");
        s.append("Susan").append("Iloveyou").append("!!!");
        System.out.println(s);

        //删
        //删除[22,s.length)的字符
        s.delete(22, s.length());
        System.out.println(s.toString());

        //改
        s.replace(0,8,"Qinzi");
        System.out.println(s.toString());

        //查
        //查找指定子串在字符串中的第一次索引，找不到则返回-1
        int indexof1 = s.indexOf("Tenerife");
        System.out.println(indexof1);
        int indexof2 = s.lastIndexOf("Qinzi");//从后往前
        System.out.println(indexof2);
        int indexof3 = s.indexOf("Susan");
        System.out.println(indexof3);


        //插
        //在索引为14的地方插入Tenerife 原来后面的内容自动后移
        s.insert(14,"Tenerife");
        System.out.println(s);



        System.out.println(s.length());

    }
}
