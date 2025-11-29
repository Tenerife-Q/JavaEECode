package com.thread.synchronized_code;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 16:07
 */
public class Account {
    private double money;
    private String ID;

    public Account(double money) {
        this.money = money;
    }


    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        //这里如果是静态方法 锁就用 类名.class 字节码
        synchronized (this) {
            if(this.money >= money) {
                System.out.println(name + " take out " + money);
                this.money -= money;
                System.out.println(name + "last :" + this.money);

            }else {
                System.out.println( name+ "money doesn't enough");
            }
        }
    }
}


