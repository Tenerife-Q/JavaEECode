package com.thread;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 15:00
 *
 * 优化说明：
 * 本文件重点演示并讲解以下内容：
 *  - Thread 名称：getName() / setName(String)
 *  - 获取当前线程：Thread.currentThread()
 *  - 让当前线程睡眠：Thread.sleep(long millis)
 *  - Thread 提供的常用构造器（示例说明）
 *
 * 要点总结（在代码中也有详细注释）：
 *  - Thread.sleep(...) 是一个静态方法，作用于“调用它的当前线程”，并抛出 InterruptedException。
 *  - Thread.currentThread() 返回正在执行代码的 Thread 对象（常用于在 run() 中获取当前线程信息）。
 *  - getName()/setName(...) 获取或设置线程的名字（可以在 start 之前或之后设置名字；setDaemon 必须在 start 之前设置）。
 *  - 常见 Thread 构造器包含：
 *      Thread()
 *      Thread(Runnable target)
 *      Thread(Runnable target, String name)
 *      Thread(String name)               // 常用时需同时重写 run()（如通过匿名子类）
 *      Thread(ThreadGroup group, Runnable target, String name)
 *      Thread(ThreadGroup group, Runnable target, String name, long stackSize) // 较少用
 *
 * 使用建议：
 *  - 如果只需要异步任务并拿到结果，请优先使用 ExecutorService + submit/Callable。
 *  - 仅用于演示/学习或简单场景时可直接使用 Thread。
 */
public class ThreadMethod04 {
    public static void main(String[] args) {
        System.out.println("=== demo: name, currentThread, sleep ===");
        demoNameCurrentThreadSleep();

        sleepMillis(400); // 等待上面示例有序输出

        System.out.println("\n=== demo: Thread 构造器示例 ===");
        demoThreadConstructors();

        sleepMillis(400);

        System.out.println("\n=== 结束示例 ===");
    }

    /**
     * 演示 getName()/setName(), Thread.currentThread(), Thread.sleep(long)
     *
     * 要点：
     *  - Thread.sleep(...) 会让当前线程暂停指定毫秒数（会释放 CPU 时间片但不会释放 synchronized 锁）。
     *  - sleep 抛出 InterruptedException，通常需要在 catch 中处理中断逻辑或恢复中断状态。
     *  - Thread.currentThread() 在任意位置都返回当前执行线程对象（在 run() 内外都可调用）。
     */
    static void demoNameCurrentThreadSleep() {
        Runnable task = () -> {
            // 在 run() 内获取当前线程并显示名字
            Thread t = Thread.currentThread();
            System.out.println("[task] start: currentThread.getName() = " + t.getName());

            // 演示 sleep：这里是让当前执行此 lambda 的线程睡眠（不是让主线程睡）
            try {
                System.out.println("[task] sleeping 300ms ...");
                Thread.sleep(300); // 必须处理 InterruptedException
                System.out.println("[task] woke up");
            } catch (InterruptedException e) {
                // 如果其他线程调用了 thisThread.interrupt()，sleep 会抛出 InterruptedException
                System.out.println("[task] was interrupted during sleep");
                // 可选择清理资源或恢复中断标志： Thread.currentThread().interrupt();
            }

            System.out.println("[task] end: currentThread.getName() = " + t.getName());
        };

        Thread t = new Thread(task); // 使用无参构造器 + 将 Runnable 传入 (Thread(Runnable))
        System.out.println("主线程：t.getName()（默认）= " + t.getName());

        // 可以在 start 之前设置名字（常见做法）
        t.setName("Worker-SetName-BEFORE-Start");
        System.out.println("主线程：setName(...) 后 t.getName() = " + t.getName());

        t.start();

        // 也可以在线程启动后修改名称（线程仍可运行，名字会被修改）
        sleepMillis(50);
        System.out.println("主线程：在子线程运行后再修改名字（示例）");
        t.setName("Worker-SetName-AFTER-Start");
        System.out.println("主线程：修改后 t.getName() = " + t.getName());

        // 等待 t 结束以便示例输出有序
        try {
            t.join();
        } catch (InterruptedException ignored) {}
    }

    /**
     * 演示 Thread 的不同构造器（提供常用构造器的示例用法）
     *
     * 说明：不是要覆盖所有重载，但演示最常用的几种并说明差别。
     */
    static void demoThreadConstructors() {
        Runnable r = () -> {
            Thread cur = Thread.currentThread();
            System.out.println("[r] running in thread: name=" + cur.getName() + ", group=" + (cur.getThreadGroup() != null ? cur.getThreadGroup().getName() : "null"));
            sleepMillis(100);
        };

        // 1) Thread() + set Runnable later (最基本)
        Thread t1 = new Thread(r); // Thread(Runnable target)
        t1.setName("t1-basic");
        t1.start();

        // 2) Thread(Runnable target, String name)  - 在构造时传入 Runnable 与 名称
        Thread t2 = new Thread(r, "t2-with-name");
        t2.start();

        // 3) Thread(String name) - 传入名字，需要通过匿名子类或后续 setRunnable 的方式定义 run()
        Thread t3 = new Thread("t3-name-only") {
            @Override
            public void run() {
                // 因为使用了 Thread(String) 构造器（只设置名字），需要重写 run() 才能执行任务
                Thread cur = Thread.currentThread();
                System.out.println("[t3] run() called in thread: " + cur.getName());
                sleepMillis(50);
            }
        };
        t3.start();

        // 4) Thread(ThreadGroup group, Runnable target, String name) - 线程组与名称同时指定
        ThreadGroup group = new ThreadGroup("MyGroup");
        Thread t4 = new Thread(group, r, "t4-group");
        t4.start();

        // 5) 更少用但存在的构造器：Thread(ThreadGroup group, Runnable target, String name, long stackSize)
        //    通常不需要使用 stackSize，JVM 可能忽略该参数；在某些平台用于调整线程栈大小。
        Thread t5 = new Thread(group, r, "t5-with-stacksize" /*, 0L*/); // 这里不传 stackSize（如需示例可添加，但通常不必要）
        t5.start();

        // 等待上述线程结束（示例目的）
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ignored) {}
    }

    // 小工具：示例中的 sleep，方便调用并吞掉 InterruptedException（演示用）
    static void sleepMillis(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
            // 演示代码中我们选择忽略中断异常。
            // 在生产代码中，建议在 catch 中处理或恢复中断状态：
            // Thread.currentThread().interrupt();
        }
    }
}