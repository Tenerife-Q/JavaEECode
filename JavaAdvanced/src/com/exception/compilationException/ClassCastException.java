package com.exception.compilationException;

/**
 * @author Tenerife
 * Su san
 */
public class ClassCastException {
    public static void main(String[] args) {
        A b1 = new B();
        B b2 = (B) b1;
        C c1 = (C)b1;//这里试图将对象强制转换为不是该实例的子类，会抛出该异常
    }
}

class A {}
class B extends A {}
class C extends A {}
