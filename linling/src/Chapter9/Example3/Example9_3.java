package Chapter9.Example3;

import java.io.*;
public class Example9_3 {
   public static void main(String args[]) {
      try{ 
           Runtime ec=Runtime.getRuntime();
           File file=new File("Notepad.exe");
           ec.exec(file.getName());
           file=new File
           ("C:/Program Files/Microsoft Office/root/Office16/Excel.exe");
           ec.exec(file.getAbsolutePath());
      }
      catch(Exception e) {
         System.out.println(e);
      } 
   } 
}

