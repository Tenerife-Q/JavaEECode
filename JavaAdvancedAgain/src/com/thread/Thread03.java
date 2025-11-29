package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/6 14:17
 *
 * 创建线程对象方式三  Callable接口 FutureTask类
 * 可以返回执行完毕后的结果
 */
public class Thread03 {
    public static void main(String[] args) {

        // 1) 使用已有的 MyCallable 类（保留 v1 的写法）

        MyCallable mc1 = new MyCallable(100);
        //把Callable对象封装成FutureTask对象
        //本质是一个Runnable线程任务对象 继承Runnable 所以可以交给Thread线程对象进行处理
        //也可获取线程执行完毕后的结果
        FutureTask<String> ft1 = new FutureTask<>(mc1);//public FutrueTask(Callable<V> callable)
        new Thread(ft1, "Worker-MyCallable-100").start();//public Thread(Runnable target, String name)

        // 2) 使用匿名内部类实现 Callable（等价实现）
        FutureTask<String> ft2 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int n = 50;
                int sum = 0;
                for (int i = 0; i <= n; i++) {
                    sum += i;
                }
                return "匿名内部类计算 0 - " + n + " = " + sum;
            }
        });
        new Thread(ft2, "Worker-Anon-50").start();

        // 3) 使用 lambda 表达式实现 Callable，并保留 FutureTask 引用（推荐当需要返回值时）
        //    注意：Callable.call() 无参，lambda 不能声明参数，但可以捕获外部变量（必须是 effectively final）

        int nLambda = 30; // effectively final（这里不再修改），供 lambda 捕获使用
        FutureTask<String> ft3 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0; i <= nLambda; i++) {
                sum += i;
            }
            return "Lambda 计算 0 - " + nLambda + " = " + sum;
        });
        new Thread(ft3, "Worker-Lambda-30").start();

        // 4) 内联 one-liner 写法（语法合法），但不保留 FutureTask 引用
        //    new Thread(new FutureTask<>(() -> ...)).start();
        //    缺点：无法在后续调用 ft.get() 获取返回值、也无法取消或检查 FutureTask 状态
        //    这种写法适用于“不需要返回值，只想异步执行一次任务”的场景
        new Thread(new FutureTask<>(() -> {
            // 简单演示：立即创建任务并启动，但我们不保存 FutureTask 引用
            // 因为没有引用所以无法获取返回值
            System.out.println("内联 FutureTask 执行（无法通过引用 get 返回值）");
            return "inline-result";
        }), "Worker-Inline-FutureTask").start();


        // 获取并打印每个 FutureTask 的结果（get() 会阻塞直到线程完成）
        // 如果你想要返回值，一定要保留 FutureTask 的引用（如 ft1/ft2/ft3）
        try {
            // 如果主线程发现第一个线程还没有执行完毕 就会让出cpu等第一个线程执行完毕才会往下继续
            System.out.println("ft1 -> " + ft1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            System.out.println("ft2 -> " + ft2.get());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("ft3 -> " + ft3.get());
        } catch (Exception e){
            e.printStackTrace();
        }

        // 注意：之前内联的那个 FutureTask 没有引用，无法再调用 get()。
        // 如果你需要在启动时就拿到 Future/Vaule，建议使用 ExecutorService.submit(...) 或保留 FutureTask 变量。
    }
}


class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return "子线程计算0 - " + n + " = " + sum;
    }
}