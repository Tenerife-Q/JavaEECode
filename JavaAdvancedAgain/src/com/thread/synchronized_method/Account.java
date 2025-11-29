package com.thread.synchronized_method;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 16:07
 *
 *
 */
public class Account {
    private double money;
    private String ID;

    public Account(double money) {
        this.money = money;
    }


    public synchronized void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        if(this.money >= money) {
            System.out.println(name + " take out " + money);
            this.money -= money;
            System.out.println(name + "last :" + this.money);

        }else {
            System.out.println( name+ "money doesn't enough");
        }
    }
}


