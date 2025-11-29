package com.io.ioCopy;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 18:49
 * <p>
 * 不需要finally 使用 try-with-resourse
 * try结构里面自动释放内存
 */
public class FreeMemory {
    public static void main(String[] args) {
        copyFile("D:/code/address.png", "E:/iLink/newAddress.png");
    }

    public static void copyFile(String srcPath, String destPath) {
        //1. 创建一个文件字节输入流管道与源文件接通

        try (
                //这里只能放入资源对象（继承了Closeable等接口） 用完后会自动调用其close()方法关闭
                InputStream fis = new FileInputStream(srcPath);
                OutputStream fos = new FileOutputStream(destPath);
        ) {

            //2. 读取一个字节数组，写入一个字节数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("copy success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
