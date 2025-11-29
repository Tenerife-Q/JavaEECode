package com.homework;

/**
 * @author Tenerife
 * Su san
 *
 * 类加载过程只执行一次，静态变量只加载一次，因此静态变量也只初始化一次
 * color 是静态变量，所有对象共享同一个值。无论在哪个构造器中修改，都会影响所有实例。
 * 创建对象实例，调用不同构造器进行修改静态变量，不会触发类重新加载
 */

/**
 * 类的加载过程
 * 加载（Loading）：
 * 类的字节码被加载到 JVM 中。
 * 链接（Linking）：
 * 分为验证（Verify）、准备（Prepare，分配内存并初始化静态变量为默认值）、解析（Resolve）。
 * 初始化（Initialization）：
 * 执行静态变量的赋值语句和静态代码块。
 */
class Car {
    double price = 10; // 实例变量
    static String color = "white"; // 静态变量

    public String toString() {
        return price + "\t" + color;
    }

    public Car() {
        this.price = 9;
        this.color = "red"; // 修改静态变量
    }

    public Car(double price) {
        this.price = price;
        this.color = "blue"; // 修改静态变量
    }
}

public class Homework01 {
    public static void main(String[] args) {
        //这里第一次加载Car类，会初始化
        Car c = new Car();       // 调用无参构造器
        System.out.println(c);   // 输出：9.0 red

        //这里是再一次使用之前加载了的Car类，不会重新加载
        Car c1 = new Car(100);   // 调用带参构造器

        System.out.println(c);   // 输出：9.0 blue
        System.out.println(c1);  // 输出：100.0 blue
    }
}

/**
 * 触发初始化的场景（主动使用）	      不触发初始化的场景（被动使用）
 * 1. new 一个对象	              1. 通过子类访问父类的静态变量
 * 2. 访问类的静态变量或方法	      2. 定义类的数组
 * 3. 通过反射 Class.forName()	  3. 访问类的编译时常量（static final）
 * 4. 初始化子类时（会先初始化父类）	  4. 使用 ClassLoader.loadClass()
 * 5. JVM 启动时的主类
 */

