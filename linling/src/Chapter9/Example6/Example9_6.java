package Chapter9.Example6;

import java.io.*;
public class Example9_6 {
   public static void main(String args[]) {
      File sourceFile = new File("src\\Chapter9\\Example6\\b.txt");  //读取的文件
      File targetFile = new File("src\\Chapter9\\Example6\\a.txt");  //写入的文件
      char c[] =new char[19];               //char型数组 
      try{  
         Writer out = new FileWriter(targetFile,true); //指向目的地的输出流
         Reader in  = new FileReader(sourceFile);   //指向源的输入流  
         int n = -1;
         while((n=in.read(c))!=-1) {
             out.write(c,0,n);
         }
         out.flush();
         out.close();
      }
      catch(IOException e) {
          System.out.println("Error "+e);
      }
  }
}

