package com.homework.shapeCal;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/27 15:29
 */
public class Rectangle extends Shape{
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        super("Rectangle");
        this.a = a;
        this.b = b;
    }


    @Override
    public double calArea() {
        return a*b;
    }

    @Override
    public double calPerimeter() {
        return 2*(a+b);
    }
}
