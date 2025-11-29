package com.io.ioCopy;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 17:33
 *
 * 使用字节流完成复制
 */
public class Copy {
    public static void main(String[] args) {
        copyFile("D:/code/address.png","E:/iLink/newAddress.png");
    }

    public static void copyFile(String srcPath, String destPath)  {
        //1. 创建一个文件字节输入流管道与源文件接通
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);
            //2. 读取一个字节数组，写入一个字节数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("copy success");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
