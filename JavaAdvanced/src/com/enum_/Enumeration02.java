package com.enum_;

import org.w3c.dom.ls.LSOutput;
/**
 * @author Tenerife
 * Su san
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WINTER);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.SPRING);


        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy);//源码toString输出枚举对象名字
        System.out.println(boy == boy2);
        //因为枚举变量申明编译器自动帮写
        // Public final static Gender BOY = new Gender();
        //所以枚举变量自然就是静态常量对象，且此处调用的是构造器
    }
}

/*
    1.当用enum关键字开发枚举类时，默认会继承java.lang.Enum,而且都是final类隐式继承（特殊编译机制）
    2.简化后的枚举对象，调用参数不同，构造器就不同，如果是无参构造器，则连括号都能省略，如下面SIJI
    3.枚举对象逗号间隔，分号结尾，且必须放在枚举类行首
    4.枚举类和普通类一样可以实现接口
 */

//枚举类
enum Season2 {
    SPRING("spring","warm"),
    SUMMER("summer","hot"),
    WINTER("winter","cold"),
    AUTUMN("autumn","cool"),
    SIJI;

    private String name;
    private String description;

    private Season2(){

    }
    //写了带参构造器，就必须写一遍无参构造器，因为被覆盖了
    //如果只调用无参就可省略
    private Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


enum Gender{
    BOY,GIRL;
}


