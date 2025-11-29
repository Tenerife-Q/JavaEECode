package com.thread;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 13:42
 *
 * 创建线程的方式一 继承Thread类
 * 编码简单 但是单线程无法继承其他类
 */
public class Thread01 {
    public static void main(String[] args
    ) {
        //子线程创建对象再调用start()启动线程
        Thread t1 = new MyThread();
        t1.start();

        //主线程不能放在子线程之前 否则线程执行就没有并发
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程：" + i);
        }
    }
}
