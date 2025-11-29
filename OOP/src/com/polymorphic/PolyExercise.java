package com.polymorphic;

//属性：静态绑定，访问结果由引用类型决定（编译时确定）。
//方法：动态绑定，调用结果由对象实际类型决定（运行时确定）。


public class PolyExercise {
    public static void main(String[] args) {
        Sub s = new Sub();
        //属性遵循静态绑定，通过子类引用访问时，直接获取子类的 count（20）。
        System.out.println(s.count);//20

        //Sub 重写了 display() 方法，调用时执行子类版本，this.count 指向子类的 count（20）。
        s.display();//20

        //向上转型 b 是父类 Base 的引用，但指向的仍是 Sub 类型的对象（与 s 指向同一个对象）。
        Base b = s;

        //通过父类引用访问时，获取的是父类的 count（10）（子类的 count 只是隐藏了父类的，并未覆盖）。
        System.out.println(b.count);//10

        //b 和 s 虽然类型不同，但指向同一个对象（内存地址相同）。
        System.out.println(b == s);//true

        //方法遵循动态绑定（多态），调用时根据对象实际类型（Sub）执行子类重写的 display() 方法
        // ，this.count 仍指向子类的 count（20）。
        b.display();//20
    }
}

class Base {
    int count = 10;
    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;
    public void display() {
        System.out.println(this.count);
    }
}