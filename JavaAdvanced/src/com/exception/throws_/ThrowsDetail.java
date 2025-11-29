package com.exception.throws_;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 15:55
 */
public class ThrowsDetail {
    public static void main(String[] args) {
        f2();
    }

    //运行时异常，程序中没有处理，默认用throws处理

    public static void f2()/* throws ArithmeticException*/ {
        int n1 = 9;
        int n2 = 0;
        double res = n1 / n2;
    }
}

class Father{
    public void method() throws RuntimeException{

    }
}

//   子类重写父类方法时，所抛出异常类型要么与父类一致，要么是父类抛出异常的子类
//   类似于继承下，子类的访问修饰权限不能小于父类

class Son extends Father{
    @Override
    public void method() throws ArithmeticException{

    }
}
