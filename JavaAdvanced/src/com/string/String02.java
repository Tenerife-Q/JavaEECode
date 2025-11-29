package com.string;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 14:06
 */
public class String02 {
    public static void main(String[] args) {
        String a = "Tenerife";//a指向常量池中的字符串内容
        String b = new String("Tenerife");//b指向堆中对象 得到常量池中常量再返回给堆中常量池的地址 相当于中转站
        //重写了equal方法
        System.out.println(a.equals(b));//T

        // == 基本数据类型比较值，引用数据类型比较地址 String是引用数据类型
        System.out.println(a == b);//F

        //b.intern()方法最终返回的是常量池的地址(对象)
        //所以与a所指向的地址相同
        System.out.println(a == b.intern());//T
        System.out.println(b == b.intern());//F

        //hashcode重写了 不再是比较地址，而是依靠算法转化为哈希码，所以相同
        System.out.println(b.hashCode());
        System.out.println(a.hashCode());


        System.out.println("=====================================");


        Person p1 = new Person();
        p1.name = "Tenerife";
        Person p2 = new Person();
        p2.name = "Tenerife";

        System.out.println(p1.equals(p2));//F
        //就是常量池中地址比较
        System.out.println(p1.name.equals(p2.name));//T
        System.out.println(p1.name == p2.name);//T
        System.out.println(p1.name == "Tenerife");//T

        String s1 = new String("Su san");
        String s2 = new String("Su san");
        System.out.println(s1 == s2);//F

    }
}

class Person{
    public String name;
}
