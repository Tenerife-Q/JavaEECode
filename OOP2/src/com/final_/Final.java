package com.final_;

public class Final {
    public static void main(String[] args) {
        Circle circle = new Circle(7.6);
        System.out.println(circle.calArea());
    }
}

//class A{
//    public final static int num = 122;
//    //编译期常量不用加载和类初始化
//    static{
//        System.out.println("A静态代码块被执行");
//    }
//}

//三种赋值方法 静态变量final必须赋值 3.14
class Circle{
    private double radius;
    private final double PI; // = 3.14;

    public Circle(double radius){
        this.radius = radius;
        PI = 3.14;
    }

//    {
//        PI = 3.14;
//    }

    public double calArea(){
        return PI * radius * radius;
    }
}