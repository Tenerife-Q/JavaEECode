package com.bignum;

import java.math.BigInteger;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 16:07
 */
public class BigInteger_ {
    public static void main(String[] args) {
        //当需要处理比较大的整数时  传入字符串 底层会自己转
        BigInteger bigInteger = new BigInteger("1546415123151131546479898");
        BigInteger bigInteger1 = new BigInteger("1546415123151131546479898");
        System.out.println(bigInteger);

        //特殊加减乘除对应方法
        bigInteger = bigInteger.add(bigInteger1);
        System.out.println(bigInteger);
        bigInteger = bigInteger.subtract(bigInteger1);
        System.out.println(bigInteger);
        bigInteger = bigInteger.multiply(bigInteger1);
        System.out.println(bigInteger);
        bigInteger = bigInteger.divide(bigInteger1);
        System.out.println(bigInteger);
    }
}
