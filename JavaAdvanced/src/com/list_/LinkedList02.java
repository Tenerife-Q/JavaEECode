package com.list_;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/26 19:32
 *
 *
 * 查询慢每个数据都需要从头修改 链表增删相对数据较快
 *
 * 这里需要做一个队列
 */
public class LinkedList02 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        //入队
        queue.addLast("Tenerife");
        queue.addLast("Su san");
        queue.addLast("QinZi");
        queue.addLast("yunru");
        System.out.println(queue);

        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        System.out.println("=========================================");


        //栈
        LinkedList<String> stack = new LinkedList<>();
        //压栈
        //push 调用的就是 addFirst 互相等价 下面压栈一样
        stack.push("Tenerife");
        stack.addFirst("Su san");
        stack.addFirst("QinZi");
        stack.addFirst("yunru");
        System.out.println(stack);

        //出栈
        System.out.println(stack.removeFirst());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
