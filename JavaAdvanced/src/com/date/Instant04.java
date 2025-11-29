package com.date;

import java.time.Instant;
import java.util.Date;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 17:16
 */
public class Instant04 {
    public static void main(String[] args) {

        //静态方法 now()获取到当前时间戳对象
        Instant now = Instant.now();
        System.out.println(now.toString());
        //通过from把Instant转成Date
        Date date = Date.from(now);
        //通过date的toInstant()可以把date转化成Instant对象
        Instant instant = date.toInstant();
    }
}
