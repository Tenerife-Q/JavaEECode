package com.innerclass;
/**
 * 成员内部类
 * 是定义在外部类的成员位置与其属性和方法同级
 * 作为外部类的成员 和其他成员方法一样属于类层级
 * 作用域在整个外部类范围
 */

public class MemberInnerclass01 {
    public static void main(String[] args) {
        //外部类---访问---成员内部类
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类---访问---成员内部类，使用成员内部类三种方式，实际就一种
        //1. 相当于把new Inner08()当作是outer08的成员
        Outer08.Inner08 inner08 = outer08.new Inner08();
        System.out.println(inner08.salary);

        //2. 在外部类中编写一个方法,用于返回Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

    }
}

class Outer08 {
    private int n1 = 10;
    public String name = "Tenerife";

    //本身就是成员，所以可以用不同修饰符修饰
    class Inner08 {
        private int n1 = 65;//默认就近原则
        public double salary = 99.8;
        public void say(){
            //直接访问外部类的所有成员，包括私有成员
            System.out.println(" n1 = " + n1+ " name= " + name);
        }
    }

    public void t1(){
        //同级下使用成员内部类
        //1. 先创建外部类实例对象outer08调用外部类中方法t1()
        //2. 再在方法t1()内创建成员内部类Inner08()的实例对象inner08，访问成员内部类相关属性方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(" salary = " + inner08.salary);
    }

    public Inner08 getInner08Instance(){
        return new Inner08();
    }
}
