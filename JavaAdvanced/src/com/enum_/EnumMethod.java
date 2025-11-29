package com.enum_;

/**
 * @author Tenerife
 * Su san
 * 演示Enum类得各种方法
 */
//Enum
public class EnumMethod {
    public static void main(String[] args) {
        Season2 autumn = Season2.AUTUMN;

        //输出枚举对象名字
        System.out.println(autumn.name());

        //ordinal()输出的枚举对象次序，从0开始
        System.out.println(autumn.ordinal());

        //从反编译可看到values方法，返回Season2[]所有枚举对象
        Season2[] values = Season2.values();
        System.out.println("===遍历取出枚举对象 增强for循环===");
        for (Season2 season : values) {
            System.out.println(season);
        }

        //valueOf:将字符串转化为枚举对象，要求字符串必须为已有的常量名，否则异常
        //就在里面找，找到了返回，没找到报错
        Season2 autumn1 = Season2.valueOf(autumn.name());//AUTUMN
        System.out.println("autumn1 = " + autumn1);
        System.out.println(autumn1==autumn);

        //compareTo:比较枚举常量编号
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));
        //return self.ordinal - other.ordinal; SUMMER 编号 1  AUTUMN 3  3 - 1 = 2
    }
}
