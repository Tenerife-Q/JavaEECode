package com.polymorphic.polyparameter;

public class PolyParameterTest {
    public static void main(String[] args) {
        Worker su = new Worker("Su", 3600);
        Manager tenerife = new Manager("Tenerife", 8000, 50000);
        PolyParameterTest test = new PolyParameterTest();
        test.showEmpAnnual(su);
        test.showEmpAnnual(tenerife);

        test.testWork(su);
        test.testWork(tenerife);

        "hdfjk".equals("jdfh");
    }

    //父类引用表示子类对象
    //原因：动态绑定（Dynamic Binding）
    //在 Java 中，当通过父类引用调用方法时，方法的绑定是在运行时完成的，而不是编译时。
    //这个机制叫做动态绑定（或后期绑定）。
    //因此，尽管方法调用看起来是针对父类类型的引用，实际调用的是子类中重写的版本。
    //除了下面使用父类类型做参数parameter接收子类类型的向上转型 还有父类数组array接收子类元素的向上转型
    //都实现了统一管理 便于拓展的功能

    public void showEmpAnnual(Employee e) {//参数是父类类型 可以接受子类 向上转型
        System.out.println(e.getAnnual());
    }

    //依旧向下转型调用子类特殊方法
    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("wrong");
        }
    }
}
