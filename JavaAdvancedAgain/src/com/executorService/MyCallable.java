package com.executorService;

import java.util.concurrent.Callable;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 19:08
 */
public class MyCallable implements Callable<String> {

    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "计算0 - " + n + "的和：" + sum;
    }
}
