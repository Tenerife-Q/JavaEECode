package com.static_;

public class VisitStatic {
    public static void main(String[] args) {
        //同过类名.类变量名来访问
        //因为类变量是随着类加载而创建，所以即使没有创建对象实例也可以访问
        System.out.println(A.name);

        //通过对象名.类变量名也可以访问
        A a = new A();
        System.out.println(a.name);
    }
}


class A{
    //类变量访问依然要遵循相关访问权限
    public static String name = "Susan";
}