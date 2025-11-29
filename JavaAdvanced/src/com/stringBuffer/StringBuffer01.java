package com.stringBuffer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/19 20:12
 */
public class StringBuffer01 {
    public static void main(String[] args) {

        //1. public final class StringBuffer
        //    extends AbstractStringBuilder
        //    implements Serializable, Comparable<StringBuffer>, CharSequence
        //实现Serialzable接口可以使StringBuffer的对象串行化，即可进行网络传输

        //2. 在父类AbstractStringBuffer中 存在属性 char[] value 不被final所修饰
        //该value数组存放字符串内容，并且引出存放在堆中，不在常量池

        //3. StringBuffer是个final类 不能被继承

        //4. 因为StringBuffer字符内容是存在 char[] value 变化的过程中
        //   不用每次都更换地址，每次都创建新的对象





        //1. 创建一个大小为16的char[] 用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2. 通过构造器指定 char[] 的大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        //3. 通过给一个String 创建 StringBuffer
        StringBuffer stringBuffer2 = new StringBuffer("Tenerife");
        //char[]大小 为字符串长度加16
    }
}
