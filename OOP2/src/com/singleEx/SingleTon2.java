package com.singleEx;

/**
 * 单例模式  只需要一个实例、全局共享资源、统一管理和调度、节省资源等。
 *
 * 演示懒汉式
 * 希望在程序运行过程中只创建一个cat对象
 * 使用单例模式
 * 只有当使用getInstance() 才返回Cat对象
 * 后面再次调用时会返回上次调用创建的Cat对象
 */

public class SingleTon2 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);

        //只new执行一次
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }
}


class Cat{
    private String name;
    private static Cat cat;

    private Cat(String name) {
        this.name = name;
        System.out.println("构造器被调用。。。");
    }

    public static Cat getInstance(){
        if(cat== null){
            cat=new Cat("Su");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}