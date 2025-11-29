package com.thread.synchronized_code;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 16:10
 */
public class DrawThread extends Thread{
    private Account account;

    public DrawThread(String name, Account acc) {
        super(name);
        this.account = acc;
    }

    @Override
    public void run() {
        account.drawMoney(100000);
    }
}
