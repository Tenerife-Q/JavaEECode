package com.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 16:24
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new Date();
        System.out.println(d2);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d1);
        System.out.println(format);

        String s = "1997年01月01日 10:12:36 星期一";
        Date parse = sdf.parse(s);
        System.out.println(sdf.format(parse));
    }
}
