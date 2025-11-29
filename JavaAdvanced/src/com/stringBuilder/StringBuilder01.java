package com.stringBuilder;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 22:00
 */
public class StringBuilder01 {
    public static void main(String[] args) {
//      1. public final class StringBuilder
//                extends AbstractStringBuilder
//                implements java.io.Serializable, Comparable<java.lang.StringBuilder>, CharSequence
//
        StringBuilder stringBuilder = new StringBuilder();

        //2. 同样是final类不能被继承
        //3. 对象字符序列依旧存放在其父类 AbstractStringBuilder char[] value
        //   因此字符序列在堆中
        //4. StringBuilder 的方法没有做互斥处理，即没有synchronized关键字（已同步），适合在单线程中使用 后面线程基础会讲

    }
}
/**
 * 效率 StringBuilder > StringBuffer > String
 */