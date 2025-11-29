package com.file_;

import java.io.File;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/1 14:52
 *
 * 文件搜索
 */
public class FileSearch02 {
    public static void main(String[] args) {
        File dir = new File("E:\\learngit");
        searchFile(dir,"text65");//换个路径和非空对象
    }

    private static void searchFile(File dir, String fileName) {
        //1. 判断极端情况
        if(dir ==  null || !dir.exists() || dir.isFile()){
            return;
        }

        //2. 获取目录下所有一级文件和文件夹对象
        File[] files = dir.listFiles();

        //3. 判断当前目录下是否存在一级文件对象 存在才可遍历
        if(files != null && files.length > 0){
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(fileName)) {
                        System.out.println(file.getAbsolutePath());
                    }
                } else {
                    //如果是文件夹就递归遍历
                    searchFile(file, fileName);
                }
            }
        }
    }
}
