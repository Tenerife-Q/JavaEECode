package com.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 16:07
 *
 * 上锁解锁过程
 */
public class Account {
    private double money;
    private String ID;

    private final Lock lock = new ReentrantLock();//final防止篡改

    public Account(double money) {
        this.money = money;
    }


    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        lock.lock();
        try {
            if(this.money >= money) {
                System.out.println(name + " take out " + money);
                this.money -= money;
                System.out.println(name + "last :" + this.money);

            }else {
                System.out.println( name+ "money doesn't enough");
            }
        } finally {
            //确保解锁过程不会因为异常而跳过 用完了一定会被释放
            lock.unlock();
        }
    }
}


