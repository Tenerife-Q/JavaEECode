package com.homework.shapeCal;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/27 15:26
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle( double a, double b, double c) {
        super("triangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }
}
