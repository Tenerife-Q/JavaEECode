package Chapter9.Example5;

import java.io.*;
public class Example9_5 {
   public static void main(String args[]) {
      // 将字符串转换为字节数组
      byte[] a = "新年快乐".getBytes();
      byte[] b = "Happy New Year".getBytes();

      // 创建一个表示目标文件的对象
      File file = new File("src\\Chapter9\\Example5\\a.txt");  // 输出的目的地

      try {
         // 创建一个指向目的地的输出流（覆盖模式）
         OutputStream out = new FileOutputStream(file);
         
         // 打印文件大小，由于此时文件刚创建，所以大小为0字节
         System.out.println(file.getName() + "的大小:" + file.length() + "字节");
         
         // 向文件中写入字节数组a的内容
         out.write(a);
         out.close();  // 关闭输出流

         // 再次创建输出流，这次以追加模式打开文件
         out = new FileOutputStream(file, true);  // 准备向文件尾加内容
         
         // 打印文件大小，因为之前已经写了"新年快乐"到文件，所以这里显示的是该字符串对应的字节数
         System.out.println(file.getName() + "的大小:" + file.length() + "字节");

         // 向文件中追加字节数组b的内容
         out.write(b, 0, b.length);
         
         // 注意：这里打印的文件大小仍然是之前的值，因为还没有刷新或关闭流
         System.out.println(file.getName() + "的大小:" + file.length() + "字节");

         out.close();  // 关闭输出流
      } catch (IOException e) {
          System.out.println("Error " + e);
      }
  }
}
