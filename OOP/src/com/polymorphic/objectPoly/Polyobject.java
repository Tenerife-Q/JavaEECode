package com.polymorphic.objectPoly;

public class Polyobject {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.cry();

        //编译类型上面定义时就确定了Animal
        animal = new Cat();
        animal.cry();
    }
}
