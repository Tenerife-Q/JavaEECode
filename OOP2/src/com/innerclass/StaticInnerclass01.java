package com.innerclass;

/**
 * 静态内部类
 */

public class StaticInnerclass01 {
    public static void main(String[] args) {
        //外部类访问静态内部类
        Outer10 outer10 = new Outer10();
        System.out.println("外部类访问静态内部类");
        System.out.println(outer10.getN2());
        outer10.m1();

        //外部其他类访问静态内部类
        //前面编译类型要注意 后面都大同小异
        //1. 可以通过类名直接访问(但前提是满足访问权限)
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        System.out.println("外部其他类访问静态内部类方法1");
        inner10.say();

        //2. 写一个方法可以返回静态内部类的实例
        Outer10.Inner10 inner10getInner10 = outer10.getInner10();
        System.out.println("外部其他类访问静态内部类方法2");
        inner10getInner10.say();


        //3. 创建静态方法直接调用类名访问
        Outer10.Inner10 inner10inStatic = Outer10.getInner10inStatic();
        System.out.println("外部其他类访问静态内部类方法3");
        inner10inStatic.say();

    }
}

class Outer10 {
    private static int n1 = 10;
    private int n2 = 8;
    private static String name = "Tenerife";

    public static class Inner10 {
        private static int n1 = 9;
        private String name = "Su san";
        public void say() {
            //静态内部类访问外部类成员只能访问外部类的所有静态成员，包含私有
            System.out.println(name + " 就近原则");
            //这里因为静态不能加this 要访问外部类成员属性 Outer10.name
            //静态内部类中不能使用 Outer10.this.name，因为静态内部类没有外部类实例的上下文
            System.out.println("外部类成员属性 " + Outer10.name+"\t"+Outer10.n1);
            System.out.println(n1);
            //不能直接访问非静态成员
            //System.out.println(n2);


        }
    }

    public void m1(){
        //作用域还是同成员内部类 在整个外部类类体中
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10(){
        return new Inner10();
    }

    public static Inner10 getInner10inStatic(){
        return new Inner10();
    }

    public int getN2(){
        return n2;
    }
}
