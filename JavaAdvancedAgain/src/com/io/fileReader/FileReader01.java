package com.io.fileReader;

import java.io.FileReader;
import java.io.Reader;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 18:58
 *
 * FileReader 文件字符输入流
 *
 * 以内存为基准 可以把文件中的数据以字符形式读到内存中去
 *
 * 文件字符输入流读取字符内容到程序中来
 */
public class FileReader01 {
    public static void main(String[] args) {
        //1. 创建文件字符输入流与源文件接通
        try (
                Reader fr = new FileReader("src/com/io/fileReader/ioTest6")
        ) {
            //2. 定义一个字符数组每次读多个字符 性能较好 而且读取中文
            char[] chs = new char[3];
            int len;
            while ((len = fr.read(chs)) != -1) {
                String str = new String(chs, 0, len);
                System.out.print(str);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
