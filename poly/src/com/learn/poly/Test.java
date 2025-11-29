package com.learn.poly;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Dog(); // 父类引用指向子类对象
        Animal animal2 = new Cat();

        animal1.sound(); // 调用子类重写的方法
        animal2.sound();
    }
}
