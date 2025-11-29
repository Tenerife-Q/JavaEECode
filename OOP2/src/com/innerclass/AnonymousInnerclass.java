package com.innerclass;

/**
 * 匿名内部类
 */
public class AnonymousInnerclass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04{
    private int n1 = 10;
    public void method(){
        /*
        匿名内部类
        1. 作用域在外部类所创建方法体中
        2. 需求只使用一次 不多次定义类 例如Tiger等类只会使用一次后面就不再使用
        3. tigerplus编译类型就是接口类型IA
        4. tigerplus运行类型就是匿名内部类
         */
        /*
        底层代码
        class XXX implements IA {
            @Override
            public void cry() {
                System.out.println("Tigerplus cry....");
            }
        }
        XXX是底层分配的类名： 外部类名+$1 这里就是 Outer04$1
        */

        /*
            IA tigerplus = new IA(){
                @Override
            };
        jdk底层在创建匿名内部类Outer04$1,立即创建了实例，并把地址返回给tigerplus
         */
        IA tigerplus = new IA(){
            @Override
            public void cry() {
                System.out.println("Tigerplus cry....");
            }
        };
        System.out.println("tigerplus的运行类型：" + tigerplus.getClass());
        tigerplus.cry();

        //传统方法 定义很多类 很繁琐
        IA tiger = new Tiger();
        tiger.cry();
    }
}

interface IA{
    void cry();
}

class Tiger implements IA{
    @Override
    public void cry() {
        System.out.println("Tiger cry....");
    }
}

class Father{
    public Father(String name){

    }
    public void test(){

    }
}