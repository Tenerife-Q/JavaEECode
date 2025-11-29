package com.learn.priority;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //同一个包下不同类 无法访问private修饰的a
        a.b = 2;
        a.c = 3;
        a.d = 4;
    }
}
