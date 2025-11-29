package com.date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 17:03
 */
public class LocalDateTime03 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        //格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(ldt);
        System.out.println("格式化后" + format);


        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());

        LocalDateTime now = LocalDateTime.now();
        LocalTime now2 = LocalTime.now();
        System.out.println(now);
        System.out.println(now2);


        //plus minus
        LocalDateTime localDateTime = ldt.plusDays(988);
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = ldt.minusDays(988);
        System.out.println(localDateTime2);
    }
}
