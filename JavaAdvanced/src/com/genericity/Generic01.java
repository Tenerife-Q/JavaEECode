package com.genericity;

import java.util.ArrayList;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/24 15:57
 *
 *
 * 泛型提供了在编译阶段约束所能操作的操作类型
 * 避免强制转换可能出现的异常
 */
public class Generic01 {
    public static void main(String[] args) {
        //泛型限制了只能传入输出字符串
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        //list.add(56546);
        //list.add('j');


        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
