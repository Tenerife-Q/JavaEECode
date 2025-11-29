package com.math;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/20 14:02
 */
public class MathMethod {
    public static void main(String[] args) {
        //1. abs 绝对值
        int abs = Math.abs(-10);
        System.out.println(abs);

        //2. pow 求幂
        double pow = Math.pow(abs, 2);
        System.out.println(pow);

        //3. ceil 向上取整 返回 >= 该参数的最小整数 转成double
        double ceil = Math.ceil(-3.2);
        //int ceil2 = Math.ceil(3.6);
        System.out.println(ceil);

        //4. floor 返回 <= 该参数的最大整数
        double floor = Math.floor(-3.2);
        System.out.println(floor);

        //5. round 四舍五入
        long round = Math.round(5.5);
        System.out.println(round);

        //6. sqrt 开方 要求参数大于0
        double sqrt = Math.sqrt(5);
        System.out.println(sqrt);

        //7. random 求随机数 [0,1)
        //获取一个a-b之间的随机整数 int num = (int)(Math.random()*(b-a+1)+a)
        for (int i = 0; i < 10; i++) {
            //[2,7]
            System.out.println((int)(Math.random()*(7-2+1)+2));
        }

        //8. max min 返回最大值最小值
        int min = Math.min(5, 10);
        int max = Math.max(5, 10);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }
}
