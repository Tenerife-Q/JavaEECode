package com.modifier;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1() {
        //该方法可访问四个属性
        System.out.println("n1 =" + n1 + " n2 =" + n2 + " n3 =" + n3 + " n4 =" + n4);
    }

    protected void m2() {
        System.out.println("n2 =" + n2 + " n3 =" + n3 + " n4 =" + n4);
    }

    void m3() {
        System.out.println("n3 =" + n3 + " n4 =" + n4);
    }

    private void m4() {
        System.out.println("n4 =" + n4 + " n3 =" + n3);
    }

    public void m5() {
        m1();
        m2();
        m3();
        m4();
    }
}
