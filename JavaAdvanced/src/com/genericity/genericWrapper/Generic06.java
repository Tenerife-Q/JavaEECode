package com.genericity.genericWrapper;

import java.util.ArrayList;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 13:41
 *
 * 包装类泛型中的使用
 * 泛型和集合不支持基本数据类型，只支持对象，即引用数据类型
 */
public class Generic06 {
    public static void main(String[] args) {
        //ArrayList <int> list = new ArrayList<>();
        //泛型擦除：泛型工作只在编译阶段，所以泛型在编译后就会被擦除，所有类型恢复成Object类型

        //所以需要将基本数据类型包装成包装类对象

        //手工包装
        Integer i1 = Integer.valueOf(34);
        Integer i2 = Integer.valueOf(34);
        System.out.println(i1 == i2);//true

        //-128 ~ 127 缓存不同重新new新对象

        //自动装箱
        Integer i3 = 256;
        Integer i4 = 256;
        System.out.println(i3 == i4);//false
        //自动拆箱
        int i5 = i3;
        System.out.println(i5 == i4);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);//已经封装成对象了
        int res = list.get(0);//自动拆箱


        //包装类功能1:int -> String 很鸡肋
        int j = 23;
        String jk = Integer.toString(j);
        System.out.println(jk + 21);//2321

        //包装类功能2:String -> int 很有用 使用包装类的.valueOf()方法更加方便
        String str1 = "66";
        String str2 = "66.6";
        int s1 = Integer.parseInt(str1);
        int s2 = Integer.valueOf(str1);
        double s3 = Double.valueOf(str2);
        System.out.println(str1 + 21);//6621
        System.out.println(s1 + 21);//87
        System.out.println(s2 + 21);//87
        System.out.println(s3 + 21);//87.6
    }
}
