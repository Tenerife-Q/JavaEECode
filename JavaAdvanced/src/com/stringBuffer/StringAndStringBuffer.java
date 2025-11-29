package com.stringBuffer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 20:54
 *
 * String StringBuffer 转化
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String -> StringBuffer
        String str = "hello";
        //使用构造器 返回的才是StringBuffer对象，对str本身影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);



        //StringBuffer -> String
        StringBuffer stringBuffer2 = new StringBuffer("Su san");
        //1.使用StringBuffer的toString()方法
        String s =  stringBuffer2.toString();
        //2.使用构造器
        String s1 = new String(stringBuffer2);

    }
}
