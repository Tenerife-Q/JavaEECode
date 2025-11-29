package com.singleEx;

/*
单例模式 饿汉式
先把对象创建好
1.将构造器私有化 有可能没有使用实例却也因为static随类加载创建了
2.在类的内部直接创建static对象 在类加载时就直接创建
3.提供一个公共的static方法 方便返回对象
 */


public class SingleTon {
    public static void main(String[] args) {
        GirlFriend su = GirlFriend.getInstance();
        System.out.println(su);
    }
}

class GirlFriend{
    private String name;

    private static GirlFriend gf = new GirlFriend("Su");

    private GirlFriend(String name){
        this.name = name;
    }

    //返回实例
    public static GirlFriend getInstance(){
        return gf;
    }

//    @Override
//    public String toString() {
//        return "GirlFriend{" +
//                "name='" + name + '\'' +
//                ", gf=" + gf +
//                '}';
//    }
    //这里toString方法调用了自身对象 导致了无限循环 StackOverFlow

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
