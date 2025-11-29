package Chapter9.Example2;

import java.io.File;
public class Example9_2 {
   public static void main(String args[]) {
      File javaDir = new File("java");  //创建一个File对象，指向"java"目录
      System.out.println(javaDir.isDirectory());  // 输出javaDir是否为目录

      boolean boo = javaDir.mkdir();//在当前目录下创建名为"java"的新目录
      if(boo) {
         System.out.println("新建子目录 "+javaDir.getName()); 
      }

      File dirFile = new File(".");//获取当前工作目录的File对象
      System.out.println("全部文件（包括文件夹）:");

      String fileName[] = dirFile.list();  // 列出当前目录下的所有文件和文件夹
      if(fileName == null){
         System.out.println("没有文件");
      }
      else {
         for(String name:fileName) {
            System.out.println(name);
         }
      }

      FileAccept fileAccept = new FileAccept(); // 使用自定义过滤器来列出所有.java文件
      fileAccept.setExtendName("java");

      System.out.println("仅仅列出java源文件:");
      File file[] = dirFile.listFiles(fileAccept);

      if(file == null || file.length == 0){
          System.out.println("没有java源文件");
      }
      else {
         for(File f:file) {
             System.out.println(f.getName());
         }
      }
   }
}
