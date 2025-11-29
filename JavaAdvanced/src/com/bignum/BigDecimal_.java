package com.bignum;

import java.math.BigDecimal;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 16:14
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        //当需要保存精度需要很高的数 double不够用

        BigDecimal bigDecimal = new BigDecimal("154.6415123151131546479898");
        BigDecimal bigDecimal1 = new BigDecimal("1.6564134468451231877978746");
        System.out.println(bigDecimal);

        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
        //System.out.println(bigDecimal.divide(bigDecimal1));// Non-terminating decimal expansion; no exact representable decimal result.死循环
        //如果有无限循环小数 这样就会保留分子精度
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}
