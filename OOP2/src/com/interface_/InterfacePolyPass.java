package com.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向实现该接口类的对象实例 类似于继承
        IG ig = new Teacher();
        //IG继承了IH，Teacher类也实现了IH接口
        IH ih = new Teacher();

        ig.pass();
        ih.pass();
    }
}

interface IH {
    void pass();
}

interface IG extends IH {}

class Teacher implements IG {
    @Override
    public void pass() {
        System.out.println("多态传递现象");
    }
}