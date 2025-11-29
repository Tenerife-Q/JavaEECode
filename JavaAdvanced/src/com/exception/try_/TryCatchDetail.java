package com.exception.try_;

/**
 * @author Tenerife
 * Su san
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        try {
            String str = "Tenerife";
            int a = Integer.parseInt(str);
            //1. 如果异常发生，则直接进入catch方法内，后面代码不会执行
            System.out.println("number : " + a);
            //2. 如果异常没有发生，则按顺序执行try中的代码块，不会进入到catch
        } catch (NumberFormatException e) {
            System.out.println("exception : " + e.getMessage());
        //3. 如果不管是否发生异常，都执行finally里面的代码，可以把关闭连接，释放资源的业务逻辑添加至其中
        } finally {
            System.out.println("finally block running");
        }

        System.out.println("stay running");
    }
}
