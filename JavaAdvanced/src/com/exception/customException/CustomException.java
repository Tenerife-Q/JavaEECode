package com.exception.customException;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 16:20
 */
public class CustomException {
    public static void main(String[] args) {

        int age = 80;
        if(!(age >= 18 && age <= 20)){
            throw new AgeException("age should be between 18 and 20");
        }
        System.out.println("age is " + age);
    }
}

//自定义异常
//extends 运行时异常 调用它的方法就不用显式往上throws 可利用默认机制
class AgeException extends RuntimeException {
    public AgeException(String message) {
        //调用能将异常原因的业务逻辑添加到报错面板上的构造器，自定义异常的父类
        super(message);
        /*public Throwable(String message) {
            fillInStackTrace();
            detailMessage = message;
        }*/
    }
}

/*
throws  异常处理的方式          在方法声明处  后面跟异常类型
throw   手动生成异常对象关键字   在方法体中    后面跟异常对象
 */