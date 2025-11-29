package com.genericity;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 16:07
 *
 * shift + F6 同一修改属性名称
 *
 * 自定义泛型类
 */
public class Generic02 {
    public static void main(String[] args) {
        //使用ArrayList集合自定义自己的集合MyArrayList
        MyArrayList<String> mlist = new MyArrayList<>();
        mlist.add("Hello");
        mlist.add("World");
        System.out.println(mlist);

        System.out.println(mlist.remove("World"));
        System.out.println(mlist);

    }
}
