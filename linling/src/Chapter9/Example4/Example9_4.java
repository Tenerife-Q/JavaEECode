package Chapter9.Example4;

import java.io.*;

public class Example9_4 {
   public static void main(String args[]) {
      int n = -1; // 用于存储每次读取的字节数量
      byte[] a = new byte[100]; // 创建一个大小为100的字节数组，用于暂存读取的数据

      try {
         // 创建一个指向特定文件的File对象
         File f = new File("src\\Chapter9\\Example4\\Example9_4.java");
         
         // 使用FileInputStream打开该文件作为输入流
         InputStream in = new FileInputStream(f);

         // 循环读取文件，直到文件结束
         while ((n = in.read(a, 0, 100)) != -1) { // 每次尝试读取最多100个字节
            // 将读取的字节数组转换为字符串并输出
            String s = new String(a, 0, n);
            System.out.print(s);
         }

         // 关闭输入流以释放资源
         in.close();
      } catch (IOException e) {
         // 捕获并处理可能发生的I/O异常
         System.out.println("File read Error" + e);
      }
   }
}


