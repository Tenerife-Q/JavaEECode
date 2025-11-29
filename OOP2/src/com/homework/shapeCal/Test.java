package com.homework.shapeCal;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/27 15:28
 */
public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        for (int i = 0; i < shapes.length; i++) {
            shapes[0] = new Circle(2.6);
            shapes[1] = new Rectangle(6,8);
            shapes[2] = new Triangle(2.4,3.6,9.8);
        }

        for (Shape shape : shapes) {
            shape.display();
        }
    }
}
