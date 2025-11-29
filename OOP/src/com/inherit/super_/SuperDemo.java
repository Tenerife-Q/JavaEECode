package com.inherit.super_;

class Parent {
    String name = "父类属性";

    // 父类无参构造
    Parent() {
        System.out.println("父类无参构造");
    }

    // 父类有参构造
    Parent(String msg) {
        System.out.println("父类有参构造: " + msg);
    }

    void print() {
        System.out.println("父类print方法");
    }
}

class Child extends Parent {
    String name = "子类属性";

    // 子类无参构造
    Child() {
        // 隐式调用父类无参构造super()
        System.out.println("子类无参构造");
    }

    // 子类有参构造
    Child(String msg) {
        super("传递给父类的信息"); // 显式调用父类有参构造
        System.out.println("子类有参构造: " + msg);
    }

    void print() {
        super.print(); // 调用父类的print方法
        System.out.println("子类print方法");
        System.out.println("访问父类属性: " + super.name); // 访问父类的name属性
        System.out.println("访问子类属性: " + this.name);   // 访问子类的name属性
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        System.out.println("=== 创建无参子类对象 ===");
        new Child();

        System.out.println("\n=== 创建有参子类对象并调用方法 ===");
        Child child = new Child("测试信息");
        child.print();
    }
}
