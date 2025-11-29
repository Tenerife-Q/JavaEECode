package Chapter9.Example10;

import java.io.*;
public class Example9_10 {
   public static void main(String args[]) {
      try {
        
         ByteArrayOutputStream outByte=new ByteArrayOutputStream(); //创建一个ByteArrayOutputStream实例outByte，用于收集写入的数据。
         byte [] byteContent="mid-autumn festival".getBytes(); //将字符串转换为字节数组。
         outByte.write(byteContent); //将字节数组写入到outByte输出流中。
         
         
         ByteArrayInputStream inByte=new ByteArrayInputStream(outByte.toByteArray());//使用outByte中的数据创建一个新的ByteArrayInputStream实例inByte，以便从中读取数据。
         byte backByte []=new byte[outByte.toByteArray().length];//创建一个新的字节数组backByte，其长度与outByte中的数据长度相同。
         inByte.read(backByte);//从inByte输入流中读取数据到backByte数组中。
         
         System.out.println(new String(backByte));
         
         
         CharArrayWriter outChar=new CharArrayWriter(); //创建一个CharArrayWriter实例outChar，用于收集写入的数据。
         char [] charContent="中秋快乐".toCharArray(); //将字符串转换为字符数组。
         outChar.write(charContent); //将字符数组写入到outChar输出流中。
         
         
         CharArrayReader inChar=new CharArrayReader(outChar.toCharArray());//使用outChar中的数据创建一个新的CharArrayReader实例inChar，以便从中读取数据。
         char backChar []=new char[outChar.toCharArray().length];//创建一个新的字符数组backChar，其长度与outChar中的数据长度相同。
         inChar.read(backChar);//从inChar输入流中读取数据到backChar数组中。
         System.out.println(new String(backChar));
      }
      catch(IOException exp){}
  }
}
