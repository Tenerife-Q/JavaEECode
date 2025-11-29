package Chapter9.Example7;

import java.io.*;
import java.util.*;
public class Example9_7 {
   public static void main(String args[]) {
      // 定义源文件和目标文件
      File fRead = new File("src\\Chapter9\\Example7\\english.txt");
      File fWrite = new File("src\\Chapter9\\Example7\\englishCount.txt");

      try {
          // 创建字符输出流和缓冲输出流
          Writer out = new FileWriter(fWrite);
          BufferedWriter bufferWrite = new BufferedWriter(out);

          // 创建字符输入流和缓冲输入流
          Reader in = new FileReader(fRead);
          BufferedReader bufferRead = new BufferedReader(in);

          String str;
          // 逐行读取源文件
          while ((str = bufferRead.readLine()) != null) {
              // 使用StringTokenizer分割字符串为单词
              StringTokenizer fenxi = new StringTokenizer(str);
              int count = fenxi.countTokens();
              
              // 在原字符串后添加单词计数信息
              str = str + " 句子中单词个数:" + count;
              
              // 将处理后的字符串写入目标文件
              bufferWrite.write(str);
              bufferWrite.newLine(); // 写入换行符
          }

          // 关闭缓冲输出流和底层输出流
          bufferWrite.close();
          out.close();

          // 重新打开目标文件进行读取
          in = new FileReader(fWrite);
          bufferRead = new BufferedReader(in);
          String s;

          // 打印目标文件内容到控制台
          System.out.println(fWrite.getName() + "内容:");
          while ((s = bufferRead.readLine()) != null) {
              System.out.println(s);
          }

          // 关闭缓冲输入流和底层输入流
          bufferRead.close();
          in.close();
      } catch (IOException e) {
          System.out.println(e.toString());
      }
   }
}


