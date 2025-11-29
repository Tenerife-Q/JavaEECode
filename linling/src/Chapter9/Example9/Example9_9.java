package Chapter9.Example9;

import java.io.*;
public class Example9_9 {
   public static void main(String args[]) {
      RandomAccessFile in=null;
      try{ 
           //创建一个新的RandomAccessFile实例，关联到名为src\Chapter9\Example9\Example9_9.java的文件，并指定模式为“rw”（读写）
           in=new RandomAccessFile("src\\Chapter9\\Example9\\Example9_9.java","rw");
           long length=in.length();  //获取文件的长度
           long position=0;   //初始化position变量为0，表示从文件的起始位置开始读取。
           in.seek(position);       //将读取位置定位到文件的起始 
           while(position<length) {
              String str=in.readLine();
              byte b[]=str.getBytes("iso-8859-1"); //将字符串转换为ISO-8859-1编码的字节数组，然后再转换回字符串。
              str=new String(b);
              position=in.getFilePointer();  //使用in.getFilePointer()获取当前文件指针的位置（即下一次读取的起始位置），并更新position变量。
              System.out.println(str);
           } 
      }
      catch(IOException e){} 
   }
}


