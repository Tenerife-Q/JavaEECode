package com.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 19:27
 *
 * Exectutors有风险 自己配参数
 * 建议使用 ThreadPoolExeccutor
 */
public class ExecutorService03 {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);
    }
}
