package com.stringBuffer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 21:40
 */


public class StringBufferExercise {
    public static void main(String[] args) {

        String price = "123456.65";
        StringBuffer sb = new StringBuffer(price);

        int dotIndex = sb.lastIndexOf(".");
        // 从小数点前往前每三位插入逗号
        // 先判断i是否大于0 满足条件再进行插入 以防insert(i - 3,",")在开头也插入了,
        for (int i = dotIndex - 3; i > 0; i -= 3) {
            sb.insert(i, ",");
        }
        System.out.println(sb.toString()); // 输出123,456.65
    }
}