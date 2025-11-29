package com.innerclass;

//匿名内部类练习1

public class InnerclassExercise01 {
    public static void main(String[] args) {
        //直接调用f1()方法，传入IL类型参数
        //这里直接传了匿名内部类，因为它本身就是个对象
        //编译类型IL，运行类型InnerclassExercise01$1
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("show off...."+getClass());
            }
        });
        //传统方式 耦合度太高
        f1(new Picture());
    }

    public static void f1(IL il){
        il.show();
    }
}

interface IL{
    void show();
}

class Picture implements IL{

    @Override
    public void show() {
        System.out.println("这是一幅莫奈...");
    }
}


