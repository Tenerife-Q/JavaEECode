package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/20 16:01
 */
public class ArraysSortDIY {
    public static void main(String[] args) {
        int[] arr = {1,-1,8,0,20};

        bubble01(arr);
        System.out.println("默认排序");
        System.out.println(Arrays.toString(arr));


        bubble02(arr,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i2 - i1;
            }
        });
        System.out.println("定制排序");
        System.out.println(Arrays.toString(arr));
    }

    //结合冒泡定制
    public static void bubble02(int[] arr, Comparator c){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++){
                if(c.compare(arr[j],arr[j+1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 接口本例调用
     * 1. Comparator 是一个接口（java.util.Comparator），定义了一个比较方法 compare。
     * 2. bubble02 的参数是 Comparator，也就是说只要实现这个接口的类都可以传进来。
     * 3. 你没有提前写一个类，而是在调用的时候直接写了 new Comparator() { ... }，这就是匿名内部类。
     *    这个匿名内部类只有这一次用，所以不命名。
     *
     * 匿名内部类实现接口过程
     * 4. new Comparator() { ... } 创建了一个没有名字的新类，并且实现了 Comparator 接口。
     * 5. 里面重写了 compare(Object o1, Object o2) 方法，写了自己的排序规则。
     * 6. 这个对象直接传给了 bubble02 方法，方法里通过接口引用 c.compare(...) 来调用你的实现。
     *
     * 接口编程和多态
     * 7. bubble02 只关心传进来的对象有没有实现 compare 方法（即实现了 Comparator 接口），
     *    至于具体逻辑是什么，方法并不关心，这就叫接口编程。
     * 8. 不同的比较逻辑，可以传入不同的 Comparator 实现（可以是匿名类，也可以是普通类）。
     * 9. Java 的多态：父类/接口引用指向子类/实现类对象，实际调用的是子类/匿名类的方法（动态绑定）。
     * @param arr
     */

    public static void bubble01(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
