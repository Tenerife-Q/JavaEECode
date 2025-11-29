package com.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wukong = new LittleMonkey("wukong");
        wukong.climb();
        wukong.swim();
        wukong.fly();
    }
}

class Monkey{
    private String name;

    public Monkey(String name){
        this.name=name;
    }

    public void climb(){
        System.out.println(name + " could climb...");
    }

    public String getName() {
        return name;
    }
}

//接口
interface Fishable{
    void swim();
}

interface Birdable{
    void fly();
}

//继承
class LittleMonkey extends Monkey implements Fishable,Birdable{
    public LittleMonkey(String name){
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " could learn to swim like fish...");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " could learn to fly like bird...");
    }
}

/**
 * 当子类继承了父类就自动拥有父类功能
 * 如果子类需要扩展功能，可以通过实现接口的方式扩展
 * 可以理解成实现接口是对java单继承的扩充
 * 接口 ：like  继承 ：is
 */