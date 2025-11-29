package Chapter9.Example8;

import java.io.*;
public class Example9_8 {
   public static void main(String args[]) {
      RandomAccessFile inAndOut=null; //声明了一个RandomAccessFile类型的变量，用于后续的文件操作
      int data[]={1,2,3,4,5,6,7,8,9,10};
      try{ inAndOut=new RandomAccessFile("src\\Chapter9\\Example8\\tom.dat","rw"); //创建一个新的RandomAccessFile实例，关联到名为tom.dat的文件，并指定模式为“rw”（读写）
           for(int i=0;i<data.length;i++) {
              inAndOut.writeInt(data[i]); //使用循环遍历data数组，并通过writeInt方法将每个整数依次写入文件。每个整数占用4个字节。
           } 
           for(long i=data.length-1;i>=0;i--) { //一个int型数据占4个字节，inAndOut从
              inAndOut.seek(i*4);          //文件的第36个字节读取最后面的一个整数，
              System.out.printf("\t%d",inAndOut.readInt()); //每隔4个字节往前读取一个整数
           }
           inAndOut.close();
      }
      catch(IOException e){} 
   }
}
