package com.innerclass;

public class AnonymousInnerclassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部内部类不能访问匿名内部类
        //outer05是调用f1创建的对象 也就是下面Outer05.this
    }
}


class Outer05{
    private int n1 = 99;
    public void f1(){
        /*
        创建一个基于类的匿名内部类
        不能添加访问修饰符，因为其本质上也是个局部变量，因为不能显示使用final修饰，但它本质上就是给不能被继承的类，final就显得多余了
        局部内部类的作用域：方法和代码块，匿名内部类用一次就丢了
         */
        Person p = new Person(){
            private int n1 = 98;
            @Override
            public void hi() {
                System.out.println("Outer n1 " + Outer05.this.n1);
                System.out.println("Inner n1 " + n1);
                System.out.println("匿名内部类重写hi()");
                System.out.println(getClass());

            }
        };
        System.out.println(p.getClass());
        p.hi();//动态绑定,运行类型是 Outer05$1
        //如果没有重写则返回 Person hi()

        //上面等价于下面 匿名内部类本身也是返回对象
        //class 匿名内部类 extends Person {}
        /*
            class Outer05$ extends Person {

            }
         */
        new Person(){
            @Override
            public void hi() {
                System.out.println("等价重写但是直接调用");
                System.out.println(getClass());
            }

            @Override
            public void ok(String str) {
                super.ok(str);
                System.out.println(getClass());
            }
        }.ok("Tenerife");//.hi();运行类型都是Outer05$2
    }
}

class Person{
    public void hi(){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok() " + str);
    }
}