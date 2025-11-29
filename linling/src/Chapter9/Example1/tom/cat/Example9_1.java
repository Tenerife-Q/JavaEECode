package Chapter9.Example1.tom.cat;

import java.io.*;
public class Example9_1 {
   public static void main(String args[]) {
      File f = new File("src\\Chapter9\\Example1\\tom\\cat","Example9_1.java");
      System.out.println(f.getName()+"是可读的吗:\n"+f.canRead());
      System.out.println(f.getName()+"的长度:\n"+f.length());
      System.out.println(f.getName()+"的绝对路径:\n"+f.getAbsolutePath());
      File file = new File("new.txt");
      if(!file.exists()) {
         try {
              file.createNewFile();
              System.out.println
             ("在当前目录(运行程序的目录)下创建了新文件:\n"+file.getName());
         }
         catch(IOException exp){}
      }
   }
}
