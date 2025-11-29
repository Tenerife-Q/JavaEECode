package com.executorService;


import java.util.concurrent.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 19:06
 */
public class ExecutorService02 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                3,                       // corePoolSize
                10,                      // maximumPoolSize
                10L,                     // keepAliveTime
                TimeUnit.SECONDS,        // time unit for keepAliveTime
                new ArrayBlockingQueue<>(3), // work queue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy() // rejected execution handler
        );

        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));


        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
