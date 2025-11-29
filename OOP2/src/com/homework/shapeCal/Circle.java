package com.homework.shapeCal;


/**
 * @author Tenerife
 * Su san
 * @date 2025/11/27 15:16
 */
public class Circle extends Shape {
    private double radius;

    public Circle(double radius){
        super("circle"); //这里直接将"circle"传给父类 使用父类构造器构造 注意super关键字的用法
        this.radius = radius;
    }

    @Override
    public double calArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calPerimeter() {
        return Math.PI * 2 * radius;
    }
}
