package com.wrapper;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/16 21:15
 */


public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);

        //Cache to support the object identity semantics of autoboxing for values between -128 and 127
        //数值在-128 - 127
        //就直接从缓存数组返回 不new
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);

        /*源码
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
         */

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);


        //只要有基本数据类型，就判断的是数值是否相同
        Integer k = 127;
        int l = 127;
        System.out.println(k == l);

        Integer a = 128;
        int b = 128;
        System.out.println(a == b);
    }
}
