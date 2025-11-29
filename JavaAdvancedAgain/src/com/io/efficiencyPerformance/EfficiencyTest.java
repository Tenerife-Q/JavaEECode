package com.io.efficiencyPerformance;

import java.io.*;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/2 10:02
 * <p>
 * 缓冲流和低级流性能分析
 */
public class EfficiencyTest {
    private static final String SRC_FILE = "E:/6023/football.mp4";
    private static final String DEST_DIR = "E:/Java实验/";  // 修改：改为目录路径

    public static void main(String[] args) {
        //使用低级字节流一个一个字节形式复制文件 最慢了
        copyFile1();
        //使用低级字节流按照字节数组形式复制文件 次快
        copyFile2();
        //使用缓冲流一个一个字节进行复制 次慢
        copyFile3();
        //使用缓冲流按照字节数组进行复制 最快
        copyFile4();
    }

    private static void copyFile4() {
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                InputStream bis = new BufferedInputStream(fis);
                OutputStream fos = new FileOutputStream(DEST_DIR + "football4.mp4");  // 修改：文件名不同
                OutputStream bos = new BufferedOutputStream(fos)
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("高级缓冲字节流按照字节数组复制文件" + time + "ms");
    }

    private static void copyFile3() {
        long start = System.currentTimeMillis();
        try (
                InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(DEST_DIR + "football3.mp4"))  // 修改：文件名不同
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("高级缓冲字节流一个一个字节复制文件" + time + "ms");
    }

    private static void copyFile2() {
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                OutputStream fos = new FileOutputStream(DEST_DIR + "football2.mp4")  // 修改：文件名不同
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级字节流按照字节数组形式复制文件" + (end - start) + "ms");
    }

    private static void copyFile1() {
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                OutputStream fos = new FileOutputStream(DEST_DIR + "football1.mp4")  // 修改：文件名不同
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级字节流按照一个一个字节形式复制文件" + (end - start) / 1000 + "s");
    }
}