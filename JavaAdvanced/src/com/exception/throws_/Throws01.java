package com.exception.throws_;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 15:39
 */
public class Throws01 {
    public static void main(String[] args) {

    }

    public void f1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d://a.txt");
    }
}

/*
抛出异常，让方法调用者处理 运行时异常就不用管 编译型异常就写显式throws往上抛
throws 后面异常类型可以是方法中产生的异常类型，也可是他的父类
可抛出多个异常，也可抛出Exception
 */
