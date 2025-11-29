package com.io.bufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 20:34
 *
 * 缓冲字符输出流的使用 提升了字符输出流的写字符的性能
 * 多了换行功能 自带特有方法 .newLine()
 *
 */
public class BufferedWriter01 {
    public static void main(String[] args) {
        //1. 创建字符输出流对象 指定写出目的地
        try (
//                Writer bw = new FileWriter("src/com/io/bufferedWriter/ioTest9")//覆盖
                FileWriter fw = new FileWriter("src/com/io/bufferedWriter/ioTest9",true);//追加
                //创建缓冲字符输出流对象 把字符输出流对象作为构造函数传递给缓冲字符输出流对象 注意上面要加;
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(65);
            bw.write('b');
            bw.write('覃');
            bw.newLine();

            bw.write("hello");
            bw.write("world");
            bw.write("java爱");
            bw.newLine();

            bw.write("java",1,2);
            bw.newLine();

            char[] chars = "java".toCharArray();
            bw.write(chars);
            bw.newLine();

            bw.write(chars,1,2);
            bw.newLine();

            bw.flush();//刷新缓冲区 将其中数据全部写出
            //刷新后 流可继续使用
            //bw.close();包含了刷新 与flush()不同关闭后流不可使用

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
