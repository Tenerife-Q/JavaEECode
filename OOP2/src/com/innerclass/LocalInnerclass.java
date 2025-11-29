package com.innerclass;

/**
 * 局部内部类
 * 是定义在外部类方法体内或者代码块内 属于局部范围
 * 只能在所在方法内创建实例使用 new Inner02().f1();
 * 超出作用域无法访问 只能在作用域内访问它 比如创建实例对象
 * 且局部变量不允许使用访问修饰符 因为被作用域限制
 */

public class LocalInnerclass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("创建outer02外部类对象实例的hashcode:"+outer02);
    }
}

class Outer02{
    private int n1 = 100;
    private void m2(){
        System.out.println("外部类Outer02私有方法m2()");
    }
    public void m1(){
        // 1. 局部内部类是定义在外部类的局部位置，通常在方法
        final class Inner02{//内部类是一个局部变量，局部变量不能被修饰符修饰 但是可被final修饰 不能被继承
            private int n1 = 800;
            public void f1(){
                /*
                如果外部类与局部内部类成员重名时，默认遵循就近原则
                但是如果想访问外部类成员
                使用 外部类名.this.成员 访问
                Outer02.this 哈希地址证明等于 outer02
                outer02即在外部其他类中创建的外部类类型对象
                 */
                System.out.println("局部内部类n1 = " + this.n1 +
                        "\t外部类n1 = " + Outer02.this.n1);
                System.out.println("Outer02.this hashcode = " + Outer02.this);
                //可以直接访问外部类所有成员，包含私有的
                m2();
            }
        }

        new Inner02().f1();//外部类访问局部内部类成员 直接在方法体m1内，即局部内部类的作用域内，此处是方法体
        /*
        1. 外部类创建方法m1
        2. 方法m1()中包装局部内部类Inner02
        3. 内部类Inner02中创建方法f1使其能够调用外部类成员n1 m2() 包括私有的
        4. 局部内部类里面其作用域内（m1）创建Inner02类型对象 调用本类中方法f1()
         */
    }

}
/**
 * 局部内部类---访问--->外部类成员  直接访问
 * 外部类---访问---->局部内部类成员  创建对象再访问 注意要在作用域内
 * 外部其他类--不能访问--局部内部类 因为局部内部类本质上是一个局部变量
 * 作用域：仅仅在定义他的方法或者代码块中
 */