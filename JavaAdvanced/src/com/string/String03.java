package com.string;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 14:57
 */
public class String03 {
    public static void main(String[] args) {
        String n1 = "Tenerife";
        n1 = "Su san";
        //这里创建了两个对象
        //如果 "Tenerife" 和 "Su san" 在常量池中之前没有被创建过，则创建了两个 String 对象（都在常量池里）。
        //如果这两个字符串之前已经存在于常量池，则不会新创建对象，只是改变了 n1 的指向。

        //final class String 表示 String 这个类不能有子类，但不代表 String 类型的变量不能改变引用。
        //这里的 n1 并没有用 final 修饰，所以它可以指向不同的字符串对象。

        //（1）常量相加 看的是池
        //（2）变量相加 是在堆中

        String n2 = "hello" + "world";
        //这里编译器会优化 等价于 String n2 = "helloworld"


        String n3 = "hello";
        String n4 = "abc";
        String n5 = n3 + n4;
        //1. 先创建了一个StringBuilder sb = StringBuilder()
        //2. 执行 sb.append("hello");
        //3. sb.append("abc");
        //4. String n5 = sb.toString()
        //最后n5指向堆中对象(String) value[] -> 池中"helloabc"
        //所以创建了三个对象
        String n6 = "helloabc";
        System.out.println(n5 == n6);//F
        String n7 = "hello" + "abc";
        System.out.println(n7 == n6);//T


    }
}
