package com.exception.try_;

/**
 * @author Tenerife
 * Su san
 */
public class TryCatchDetail03 {
    public static void main(String[] args) {
        /*
        try-finally,没有捕获异常
        因此程序会直接崩溃
        应用场景：执行一段代码，无论是否发生异常，都必须执行某个业务逻辑
        放在fianlly中 且返回fianlly 不会忙着return其他catch中return 因为return只能一次 程序结束时返回
         */

        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        }finally {
            System.out.println("finally block running");
        }
    }
}
