package com.homework.shapeCal;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/27 15:11
 *
 * 注意这里定义的抽象类 抽象方法只能在抽象类里面
 * 还有就是 抽象类方法一旦被定义 就一定要重写
 */
public abstract class Shape {
    private String name;

    public Shape(String name){
        this.name = name;
    }

    public abstract double calArea();

    public abstract double calPerimeter();

    public void display(){
        System.out.println(name + " Area " +  calArea() + " perimeter " + calPerimeter() );
    }
}
