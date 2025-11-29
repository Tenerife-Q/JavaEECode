package com.collection_;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 15:13
 *
 * 遍历 Traversal
 * 迭代器遍历
 */
public class Collection03 {
    public static void main(String[] args) {
        //ArrayList 代替 Collection 接受方便下面看源码
        ArrayList<String> names = new ArrayList<>();
        names.add("Tenerife");
        names.add("Su san");
        names.add("QinZi");
        System.out.println(names);

        //1. 得到集合迭代器对象遍历
        Iterator<String> it = names.iterator();
        //iterator() 进入源码
        //hashnext() 迭代器默认指向当前集合索引未0 判断是否还有元素未遍历
        //it.next() 取元素 并将迭代器向后移一位

//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());

        while(it.hasNext()) {
            //取一个移一个 防止元素越界异常
            String name = it.next();
            System.out.println(name);
        }

        System.out.println("========================================");

        //2. 增强for
        Collection<String> names2 = new ArrayList<>();
        names2.add("Tenerife");
        names2.add("Su san");
        names2.add("QinZi");

        for(String name : names2) {
            System.out.println(name);
        }


        String[] users = {"Tenerife", "Su san", "QinZi"};
        for (String user : users) {//users.for
            System.out.println(user);//user.sout
        }

        System.out.println("==========================================");

        //3. lambda

        Collection<String> names3 = new ArrayList<>();
        names3.add("Tenerife");
        names3.add("Su san");
        names3.add("QinZi");

        names3.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        /*
        源码
        action是实现Consumer接口匿名内部类
        this是调用forEach的names3
        增强for T是String t接受集合内元素 循环内部接口回调动态绑定
        public interface Iterable<T> {
            default void forEach(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                for (T t : this) {
                    action.accept(t);   // 对每个元素调用 action.accept
                }
            }
        }
        */
        //与上面等价
        names3.forEach(s ->  System.out.println(s));

        names3.forEach(System.out::println);
    }
}
