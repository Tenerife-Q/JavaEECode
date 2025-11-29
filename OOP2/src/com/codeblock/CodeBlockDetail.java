package com.codeblock;

public class CodeBlockDetail {
    public static void main(String[] args) {
        /*
        进行类的加载
        先加载A父类 再加载B子类

        创建对象
        从子类构造器开始
         */
        new B();
    }
}

class A{
    private static int n1 = getVal01();// (1)

    static{
        System.out.println("A的一个静态代码块");// (2)
    }

    {
        System.out.println("A的一个普通代码块");// (5)
    }

    public int n2 = getVal02();// (6)

    public static int getVal01(){
        System.out.println("getVal01");// (1)
        return 10;
    }

    public int getVal02(){
        System.out.println("getVal02");// (6)
        return 20;
    }

    public A(){
        System.out.println("A的构造器");// (7)
    }
}

class B extends A{
    private static int n3 = getVal03();// (3)

    static{
        System.out.println("B的一个静态代码块");// (4)
    }

    public int n4 = getVal04();// (8)

    {
        System.out.println("B的一个普通代码块");// (9)
    }

    public static int getVal03(){
        System.out.println("getVal03");// (3)
        return 30;
    }

    public  int getVal04(){
        System.out.println("getVal04");// (8)
        return 40;
    }

    public B(){
        //隐藏super()
        //普通代码块 普通属性的初始化
        System.out.println("B的构造器");// (10)
    }
}
