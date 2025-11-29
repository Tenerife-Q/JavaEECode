package shangjishiyan5;

/**
 * 程序主入口类，用于演示 String 类的常用方法来解析和检索文本信息。
 */
public class Experiment3 {
   public static void main(String args[]) {
      // 原始的简历信息字符串
      String mess = "姓名:张三 出生时间:1989.10.16。个人网站:http://www.zhang.com。身高:185 cm,体重:72 kg";

      // --- 检索姓名 ---
      // 【代码1】: 查找第一个冒号 ":" 的位置
      int index = mess.indexOf(":");
      // 从冒号后一个位置开始截取字符串，这里会得到 "张三 出生时间..."
      String name = mess.substring(index+1);
      // 判断截取到的姓名部分是否以 "张" 开头
      if(name.startsWith("张")) {
         System.out.println("简历中的姓名姓\"张\"");
      }

      // --- 检索出生日期 ---
      // 【代码2】: 从上一个冒号之后的位置开始，查找下一个冒号的位置
      index = mess.indexOf(":", index + 1);
      // 从第二个冒号后一个位置开始，截取10个字符（"1989.10.16"的长度）
      String date = mess.substring(index+1, index+11);
      System.out.println(date);

      // --- 检索个人网站 ---
      // 找到 "个人网站" 后的冒号位置
      index = mess.indexOf(":",index+1);
      // 【代码3】: 找到 "身高" 字符串的起始位置
      int heightPosition = mess.indexOf("身高");
      // 从冒号后一个位置开始，截取到 "身高" 前一个位置，得到个人网站URL
      String personNet = mess.substring(index+1, heightPosition-1); // -1是为了去掉网站和身高之间的句号
      System.out.println(personNet);

      // --- 检索身高 ---
      // 【代码4】: 从 "身高" 所在位置之后开始，查找下一个冒号的位置
      index = mess.indexOf(":", heightPosition);
      // 找到 "cm" 的位置
      int cmPosition = mess.indexOf("cm");
      // 截取身高冒号后到 "cm" 前的字符串，即 "185 "
      String height = mess.substring(index+1, cmPosition);
      // 使用 trim() 去掉字符串两端的空格，得到 "185"
      height = height.trim();
      // 使用 Integer.parseInt() 将字符串转换为整数，以便进行数值比较
      int h = Integer.parseInt(height);
      if(h>=180) {
         System.out.println("简历中的身高"+height+"大于或等于180 cm");
      }
      else {
         System.out.println("简历中的身高"+height+"小于180 cm");
      }

      // --- 检索体重 ---
      // 【代码5】: 使用 lastIndexOf 查找最后一个冒号的位置，即体重前的冒号
      index = mess.lastIndexOf(":");
      // 找到 "kg" 的位置
      int kgPosition = mess.indexOf("kg");
      // 截取体重冒号后到 "kg" 前的字符串，即 "72 "
      String weight = mess.substring(index+1, kgPosition);
      // 去掉空格
      weight = weight.trim();
      // 转换为整数
      int w = Integer.parseInt(weight);
      if(w>=75) {
         System.out.println("简历中的体重"+weight+"大于或等于75 kg");
      }
      else {
         System.out.println("简历中的体重"+weight+"小于75 kg");
      }
   }
}