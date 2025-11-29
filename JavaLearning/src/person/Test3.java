package person;
public class Test3 {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Tenerife";
        person.age = 20;
        fun(person);//main static fun unstatic  ---  main不能 直接 调用fun
        System.out.println(person.name);
    }
    //引用数据类型 引用传递 传的是Person类型变量person栈内存指向堆内存的地址
    public static void fun(Person person){
        person.name = "blindlight";
        System.out.println(person.name);
    }
}
