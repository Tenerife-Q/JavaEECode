package com.executorService;

import java.util.concurrent.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 18:34
 */
public class ExecutorService01 {
    public static void main(String[] args) {
//        ExecutorService pool = new ThreadPoolExecutor(3, 10, 10,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ArrayBlockingQueue<>(3),
//                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        ExecutorService pool = new ThreadPoolExecutor(
                3,                       // corePoolSize
                10,                      // maximumPoolSize
                10L,                     // keepAliveTime
                TimeUnit.SECONDS,        // time unit for keepAliveTime
                new ArrayBlockingQueue<>(3), // work queue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy() // rejected execution handler
        );

        Runnable target = new MyRunnable();
        pool.execute(target);//提交一个任务 创建一个线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);//后面两个复用线程
        pool.execute(target);
    }
}
