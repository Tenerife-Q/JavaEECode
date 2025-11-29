package Chapter9.Example11;

import java.io.*;
public class Example9_11 {
   public static void main(String args[]) {
      //创建了一个File对象，指向名为apple.txt的文件。如果该文件不存在，则后续的操作会尝试创建它。
      File file=new File("src\\Chapter9\\Example11\\apple.txt");
      try{
          FileOutputStream fos=new FileOutputStream(file);//创建一个FileOutputStream实例fos，用于将字节写入指定的文件apple.txt。
          DataOutputStream outData=new DataOutputStream(fos);//创建一个DataOutputStream实例outData，以便能够写入基本数据类型。
          outData.writeInt(100);//写入一个整数。
          outData.writeLong(123456);  
          outData.writeFloat(3.1415926f);
          outData.writeDouble(987654321.1234);
          outData.writeBoolean(true);
          outData.writeChars("How are you doing ");
       } 
       catch(IOException e){}
       try{
          FileInputStream fis=new FileInputStream(file);//创建一个FileInputStream实例fis，用于从指定的文件apple.txt中读取字节。
          DataInputStream inData=new DataInputStream(fis);//创建一个DataInputStream实例inData，以便能够读取基本数据类型。
          System.out.println(inData.readInt());    //读取int数据
          System.out.println(inData.readLong());   //读取long数据 
          System.out.println(+inData.readFloat()); //读取float数据
          System.out.println(inData.readDouble()); //读取double数据
          System.out.println(inData.readBoolean());//读取boolean数据
          
          char c = '\0';
          while((c=inData.readChar())!='\0') {       //使用while循环逐个字符地读取字符序列，直到遇到空字符\0为止。
              System.out.print(c);
          } 
        }
        catch(IOException e){}
   }
}
