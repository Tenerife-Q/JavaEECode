package com.io.fileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 16:07
 *
 * 文件字节输入流 FileInputStream
 *
 * 文件字节输入流读取文件中字节数据到内存中
 *
 * 读取文本适合用字符流 字节流适合数据转移
 */
public class FileInputStream01 {
    public static void main(String[] args) throws Exception {
        //1. 创建文件字节输入流管道(构造器)与源文件接通
        //InputStream is = new FileInputStream(new File("com\\io\\fileInputStream\\ioTest"));
        InputStream is1 = new FileInputStream("src\\com\\io\\fileInputStream\\ioTest");

        //2. 读取文件中字节并输出

        //（1）read()每次读取一个字节返回 没有数据返回-1 但这样性能较差 且汉字一定乱码
        int b;
        while ((b = is1.read()) != -1) {
            System.out.print((char)b);
        }


        //（2）每次读取多个 但依然存在汉字乱码

        InputStream is2 = new FileInputStream("src\\com\\io\\fileInputStream\\ioTest2");
        //定义一个字节数组用于每次读取字节
        byte[] buffer = new byte[3];
        //定义一个变量记录每次取了多少个字节
        int len;
        while ((len = is2.read(buffer)) != -1) {
            //把读取的字节数组转换成字符串输出，读多少输出多少
            String str = new String(buffer, 0, len);
            //从第一个字节开始，只倒len个字节，这里最后避免输出倒数第二次冗余字节
            System.out.print(str);
        }

        //（3）一次读完文件所有字节  可以避免汉字乱码
        InputStream is3 = new FileInputStream("src\\com\\io\\fileInputStream\\ioTest3");
        byte[] bytes = is3.readAllBytes();

        String rs = new String(bytes);
        System.out.println(rs);


        is1.close();
        is2.close();
        is3.close();
    }
}
