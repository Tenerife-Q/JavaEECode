package com.io.bufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 20:12
 *
 * 缓冲字符输入流读取字符内容 性能提升
 * 多了按照行读取文本的能力 自带方法 .readLine() 读取一行返回 读完返回null
 */
public class BufferedReader01 {
    public static void main(String[] args) {
        //1. 创建文件字符输入流与源文件接通
        try (
                Reader fr = new FileReader("src/com/io/bufferedIOReader/ioTest8");
                BufferedReader br = new BufferedReader(fr);
        ) {
            //2. 定义一个字符数组每次读多个字符 性能较好 而且读取中文
//            char[] chs = new char[3];
//            int len;
//            while ((len = br.read(chs)) != -1) {
//                String str = new String(chs, 0, len);
//                System.out.print(str);
//            }
            //读取文本最好的方法 按照行读取
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
