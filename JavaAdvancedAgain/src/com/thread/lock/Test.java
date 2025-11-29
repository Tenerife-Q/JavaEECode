package com.thread.lock;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 16:07
 *
 * 3. 同步锁
 */
public class Test {
    public static void main(String[] args) {
        //账户类
        Account acc = new Account(100000);

        //设计线程类
        new DrawThread("xiaoming",acc).start();
        new DrawThread("xiaohong",acc).start();
    }
}
