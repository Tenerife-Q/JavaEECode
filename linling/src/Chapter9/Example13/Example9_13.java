package Chapter9.Example13;

import java.io.*;
public class Example9_13 {
   public static void main(String args[]) {
      TV changhong = new TV();
      changhong.setName("长虹电视");
      changhong.setPrice(5678); 
      
      File file=new File("src\\Chapter9\\Example13\\television.txt");
      
      try {
        // 创建 FileOutputStream 并包装成 ObjectOutputStream
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        // 将 changhong 对象写入文件
        objectOut.writeObject(changhong);
        objectOut.close(); // 关闭 ObjectOutputStream

        // 创建 FileInputStream 并包装成 ObjectInputStream
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        // 从文件中读取对象并转换为 TV 类型
        TV xinfei = (TV) objectIn.readObject();
        objectIn.close(); // 关闭 ObjectInputStream

        // 修改 xinfei 对象的属性
        xinfei.setName("新飞电视");
        xinfei.setPrice(6666);

        // 打印两个对象的属性
        System.out.println("changhong的名字:" + changhong.getName());
        System.out.println("changhong的价格:" + changhong.getPrice());
        System.out.println("xinfei的名字:" + xinfei.getName());
        System.out.println("xinfei的价格:" + xinfei.getPrice());

    } catch (ClassNotFoundException event) {
        // 如果找不到类定义，则打印错误信息
        System.out.println("不能读出对象");
    } catch (IOException event) {
        // 捕获并打印 I/O 异常信息
        System.out.println(event);
    }
}
}
