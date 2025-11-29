package com.inherit.exercise;

public class ExtendsExercise {
    public static void main(String[] args) {
        C c = new C();
    }
}

//首先进入 C() 无参构造器。
//它的第一行是 this("hh");，即调用自身的有参构造器 C(String name)。
//进入 C(String name)，第一行是 super("ss ");，即调用父类 B 的有参构造器 B(String name)。
//进入 B(String name)，但它没有显式调用 super()，Java 会自动插入对父类 A 的无参构造器 super()。
//进入 A()，输出 "A"。
//返回 B(String name)，输出 "ss B有参构造"。
//返回 C(String name)，输出 "C无参构造"。
//返回 C()，输出 "C有参构造"。

//构造器调用顺序：子类构造器的第一行如果是 this(...)，会优先调用本类其它构造方法，否则默认调用 super()。
//        super 用于调用父类构造器，且只能出现在构造方法的第一行。
//        this 用于调用本类其他构造器，也只能出现在构造方法的第一行。
//对象创建时，先构造父类，再构造子类。

class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B无参构造");
    }

    public B(String name) {
        System.out.println(name+"B有参构造");
    }
}

class C extends B {
    public C() {
        this("hh");
        System.out.println("C有参构造");
    }

    public C(String name) {
        super("ss ");
        System.out.println("C无参构造");
    }
}
