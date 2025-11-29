package com.io.bufferedIOStream;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 19:56
 *
 * 缓冲字节输入流
 * 缓冲池8KB 快速读写
 */
public class BufferedStream01 {
    public static void main(String[] args) {
        copyFile("D:/code/address.png", "E:/epic/newAddress.png");
    }

    public static void copyFile(String srcPath, String destPath) {
        //1. 创建一个文件字节输入流管道与源文件接通

        try (
                //这里只能放入资源对象（继承了Closeable等接口） 用完后会自动调用其close()方法关闭
                InputStream fis = new FileInputStream(srcPath);
                //把低级字节输入流包装成高级缓冲字节输入流
                InputStream bis = new BufferedInputStream(fis);

                //下面同理
                OutputStream fos = new FileOutputStream(destPath);
                OutputStream bos = new BufferedOutputStream(fos);
        ) {

            //2. 读取一个字节数组，写入一个字节数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("copy success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
