package com.interface_;

public class InterfaceDetail {
    public static void main(String[] args) {
        //new IA(); 1. 接口不能被初始化 实例化
        System.out.println(IB.n1);//访问接口中的静态属性 因为接口中属性n1是static静态的
        //IB.n1 = 2; // 编译错误 因为n1是final
    }
}

interface IA{
    int n2 = 5;
    void say();
    // 2. 默认省略public abstract 但是下面Override不能省略public
    //    因为Java的继承规则规定
    //    子类/实现类中重写的方法，访问权限不能比父类/接口声明的方法更严格
    //    避免父类可以被访问而子类不能
    public abstract void hi();
}

class Cat implements IA{
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}

// 3. 普通类必须实现接口中所有方法 而抽象类就可以不用实现接口的方法

abstract class Tiger implements IA{
    @Override
    public abstract void say();
}

interface IB{
    // 5. 接口中属性只能是final，而且是public static final修饰
    int n1 = 1;//等价于 public static final int n1 = 10;
    void hi();
}

interface IC{
    void say();
}

interface ID extends IB,IC{
    // 6. 接口不能继承其他类 但可以继承多个接口
    default void f1(){
        System.out.println("默认方法");
    }

    public static void f2(){
        System.out.println("static ");
    }

    private void f3(){
        System.out.println("private ");
    }
}

/*public interface IE{
    // 7. 接口修饰符可以是默认和public 但这里已经有public修饰类了
}

 */

// 4. 一个类可以同时实现多个接口
class Pig implements IB,IC{

    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}

class dick implements ID{

    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }

    @Override
    public void f1() {
        ID.super.f1();
    }
}