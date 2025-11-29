package keywords;
public class StaticExample {

    // 静态变量（类变量）：属于类本身，所有对象共享同一份数据
    static int staticCounter = 0;

    // 实例变量：属于对象，每个对象有自己独立的一份
    int instanceCounter = 0;

    // 静态方法：属于类，可以通过类名调用
    public static void incrementStaticCounter() {
        staticCounter++;
        // 静态方法不能直接访问实例变量，因为它不依赖于对象
        // System.out.println(instanceCounter); // 错误：静态方法不能直接访问实例变量
    }

    // 实例方法：属于对象，通过对象调用
    public void incrementInstanceCounter() {
        instanceCounter++;
        // 实例方法可以直接访问静态变量，因为静态变量是全局的，属于类本身
        staticCounter++;
    }

    public static void main(String[] args) {
        // 静态变量的调用方式：直接通过类名调用
        System.out.println("Initial Static Counter: " + StaticExample.staticCounter);

        // 创建对象1
        StaticExample obj1 = new StaticExample();
        obj1.incrementInstanceCounter(); // 调用实例方法，修改实例变量和静态变量
        System.out.println("Obj1 Instance Counter: " + obj1.instanceCounter);
        System.out.println("Static Counter after Obj1: " + StaticExample.staticCounter);

        // 创建对象2
        StaticExample obj2 = new StaticExample();
        obj2.incrementInstanceCounter(); // 调用实例方法，修改实例变量和静态变量
        System.out.println("Obj2 Instance Counter: " + obj2.instanceCounter);
        System.out.println("Static Counter after Obj2: " + StaticExample.staticCounter);

        // 调用静态方法
        StaticExample.incrementStaticCounter();
        System.out.println("Static Counter after static method: " + StaticExample.staticCounter);
    }
}