package com.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu tenerife = new Stu("Tenerife");
        tenerife.payFee(60000);

        Stu stulu = new Stu("Stulu");
        stulu.payFee(60000);

        //无论是对象调用还是类名调用 都能实现静态函数的使用

        Stu.payFee(60000);

        Stu.shoewFee();
    }
}

class MyTools {
    public static double calSum(double a, double b){
        return a+b;
    }
}

class Stu{
    private String name;
    private static double fee = 0;

    public Stu(String name){
        this.name=name;
    }


    //静态方法能访问静态属性
    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void shoewFee(){
        System.out.println("总学费：  " + Stu.fee);
    }
}
