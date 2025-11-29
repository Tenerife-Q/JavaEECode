package com.polymorphic;

class Animal {
    public void eat() {
        System.out.println("动物吃东西");
    }
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    // 子类特有方法
    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    // 子类特有方法
    public void watchHouse() {
        System.out.println("狗看家");
    }
}

public class UpDowncastingDemo {
    public static void main(String[] args) {
        // 1. 先向上转型：父类引用指向子类对象
        Animal animal = new Cat();
        animal.eat(); // 多态：调用Cat的eat()

        // 2. 向下转型：将父类引用转换为子类类型
        // 前提：animal原本指向的是Cat对象
        Cat cat = (Cat) animal;
        cat.catchMouse(); // 现在可以调用Cat的特有方法

        // 3. 错误示例：父类引用指向Cat，却试图转为Dog
        try {
            Dog dog = (Dog) animal; // 运行时抛出ClassCastException
        } catch (ClassCastException e) {
            System.out.println("转型失败：不能将Cat转为Dog");
        }
    }
}

//example
//Animal animal2 = new Animal();
//if (animal2 instanceof Cat) {
//Cat cat2 = (Cat) animal2;  // 只有这时才会执行
//} else {
//        System.out.println("animal2 不是 Cat 类型，不能转换！");
//}

//其中 instanceof 用于判断是否一个对象的实际类型 即animal2的实际类型是不是Cat
//编译时允许强制类型转换，只要存在父子（继承）关系。
//运行时才判断对象真实类型，不匹配就抛 ClassCastException。
//        instanceof 可以在转型前判断类型，保证类型安全。


