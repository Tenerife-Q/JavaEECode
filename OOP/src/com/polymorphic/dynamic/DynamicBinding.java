package com.polymorphic.dynamic;

//动态绑定
public class DynamicBinding {
    public static void main(String[] args) {
        // 向上转型：父类引用指向子类对象
        A a = new B();

        // 1. 动态绑定体现（方法调用看对象实际类型）
        System.out.println("a.sum() 结果：" + a.sum());    // 调用B的sum() → 20+20=40
        System.out.println("a.sum1() 结果：" + a.sum1());  // 调用B的sum1() → 20+10=30
        System.out.println("a.getI() 结果：" + a.getI());  // 调用B的getI() → 返回B的i=20

        // 2. 普通属性访问（看引用类型，无动态绑定）
        System.out.println("a.i 结果：" + a.i);            // 引用类型是A → 访问A的i=10

        // 3. 子类引用访问对比
        B b = new B();
        System.out.println("b.i 结果：" + b.i);            // 引用类型是B → 访问B的i=20
    }
}

class A {
    // 普通属性
    public int i = 10;

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    // 普通属性（隐藏父类的i，非重写）
    public int i = 20;

    // 重写父类方法（动态绑定的核心）
    @Override
    public int sum() {
        return i + 20;
    }

    // 重写父类方法
    @Override
    public int getI() {
        return i;
    }

    // 重写父类方法
    @Override
    public int sum1() {
        return i + 10;
    }
}

