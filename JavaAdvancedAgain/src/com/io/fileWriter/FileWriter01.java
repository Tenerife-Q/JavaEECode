package com.io.fileWriter;

import java.io.FileWriter;
import java.io.Writer;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 19:21
 * <p>
 * 文件字符输出流的使用 输出
 */
public class FileWriter01 {
    public static void main(String[] args) {
        //1. 创建字符输出流对象 指定写出目的地
        try (
//                Writer fw = new FileWriter("src/com/io/fileWriter/ioTest7")//覆盖
                FileWriter fw = new FileWriter("src/com/io/fileWriter/ioTest7",true)//追加
        ) {
            fw.write(65);
            fw.write('b');
            fw.write('覃');
            fw.write("\r\n");

            fw.write("hello");
            fw.write("world");
            fw.write("java爱");
            fw.write("\r\n");

            fw.write("java",1,2);
            fw.write("\r\n");

            char[] chars = "java".toCharArray();
            fw.write(chars);
            fw.write("\r\n");

            fw.write(chars,1,2);
            fw.write("\r\n");

            fw.flush();//刷新缓冲区 将其中数据全部写出
            //刷新后 流可继续使用
            //fw.close();包含了刷新 与flush()不同关闭后流不可使用

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
