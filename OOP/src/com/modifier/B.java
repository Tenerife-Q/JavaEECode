package com.modifier;

public class B {
    public void say() {
        A a = new A();
        //在同一个包下，除了private都能访问
        System.out.println("n1=" + a.n1 + " n2=" + a.n2 + " n3=" + a.n3);

        a.m1();
        a.m2();
        a.m3();
        //没有 a.m4()
        //方法限制修饰符
    }
}
