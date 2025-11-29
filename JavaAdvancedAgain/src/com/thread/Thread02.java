package com.thread;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 13:56
 *
 * 创建线程方式二
 * 实现Runnable接口
 * 任务类只是实现接口 可以继续实现其他接口 还可以继承其他类
 * 只是多了个Runnable对象
 */
public class Thread02 {
    public static void main(String[] args) {
        //匿名内部类
//        Runnable mr = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("子线程：" + i);
//                }
//            }
//        };
//        //线程任务对象交给一个线程对象来处理
//        Thread t1 = new Thread(mr);//public Thread(Runnable r)
//        t1.start();


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程输出：" + i);
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }

    }
}

//定义一个线程任务类对象实现Runnable接口
//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println("子线程输出" + i);
//        }
//    }
//}
