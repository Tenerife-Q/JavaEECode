package com.file_;

import java.io.File;
import java.io.IOException;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 13:28
 *
 * 创建file对象代表文件/目录 以及操作文件的方法
 */
public class File01 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("E:/learngit/test65.txt");

        System.out.println(f1.length());//字节个数
        System.out.println(f1.getName());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());

        //尽量使用相对路径定位文件对象
        File f2 = new File("src\\com\\file_\\pathaTest");
        System.out.println(f2.length());

        //创建对象代表不存在的文件路径
        File f3 = new File("src\\com\\file_\\pathTest");
        System.out.println(f3.exists());
        System.out.println(f3.createNewFile());

        //创建对象代表不存在文件夹路径
        File f4 = new File("src\\com\\file_\\packbag");
        System.out.println(f4.mkdir());//一级文件夹

        File f5 = new File("src\\com\\file_\\packabag\\package2\\package3");
        System.out.println(f5.mkdirs());//多级文件夹

        //创建File对象代表存在文件 文件夹 然后再删除它 只能删空文件
        File f6 = new File("src\\com\\file_\\packbag\\package2\\package3");
        System.out.println(f6.delete());

        //拿一级目录中文件名 list()
        File f7 = new File("src\\com\\file_");
        String[] names = f7.list();
        for (String name : names) {
            System.out.println(name);
        }

        //拿一级文件对象 返回对象数组  listFiles()
        File[] files = f7.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());//获取绝对路径
        }
    }
}
