package com.wrapper;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 20:36
 */
public class WrapperExercise01 {
    public static void main(String[] args) {
        //valueOf() 返回指定数据类型的包装类实例
        Double d = 100d;//自动装箱 Double.valueOf(100d)
        Float f = 1.5f;//自动装箱 Float.valueOf(1.5f)


        //三元运算符是一个整体，精度按照选项中更大那个设置
        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1);

        //与上面做对比
        Object obj2;
        if(true) obj2 = new Integer(1);
        else obj2 = new Double(2.0);
        System.out.println(obj2);


    }
}
