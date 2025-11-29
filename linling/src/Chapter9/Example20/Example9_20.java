package Chapter9.Example20;

import java.io.*;
public class Example9_20{
   public static void main(String args[]) {
      File file=new File("src\\\\Chapter9\\\\Example17\\\\Example9_17.java");
      WindowFileLock win=new WindowFileLock(file);
      win.setTitle("使用文件锁");
   }
}
