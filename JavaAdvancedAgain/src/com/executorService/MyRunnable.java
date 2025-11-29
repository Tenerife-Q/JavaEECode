package com.executorService;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 18:47
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出" + i);
        }
    }
}
