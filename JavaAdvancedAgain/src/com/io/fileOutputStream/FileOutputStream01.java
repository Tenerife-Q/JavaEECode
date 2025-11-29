package com.io.fileOutputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 17:05
 *
 *
 * 文件字节输出流
 */
public class FileOutputStream01 {
    public static void main(String[] args) throws Exception {
        //1. 创建文件字节输出流管道与目标文件接通 不需要提前创建文件 与读文件不同
        OutputStream os1 = new FileOutputStream("src\\com\\io\\fileOutputStream\\ioTest4");//覆盖管道
        OutputStream os2 = new FileOutputStream("src\\com\\io\\fileOutputStream\\ioTest5",true);//追加管道

        //2. 写入字节

        //(1) 写入一个字符
        os1.write(9);
        os1.write('b');
        os1.write("\r\n".getBytes());


        //(2)写一个字节数组
        byte[] bytes1 = "巴克什".getBytes();
        os1.write(bytes1);
        os1.write("\r\n".getBytes());

        //(3)写数组一部分
        os1.write(bytes1,0,3);
        os1.write("\r\n".getBytes());



        //(1) 写入一个字符数组
        os2.write(9);
        os2.write('b');
        os2.write("\r\n".getBytes());

        //(2)写一个字节数组
        byte[] bytes2 = "斯坦福桥".getBytes();
        os2.write(bytes2);
        os2.write("\r\n".getBytes());

        //(3)写数组一部分
        os2.write(bytes2,0,3);
        os2.write("\r\n".getBytes());



        os1.close();
        os2.close();
    }
}
