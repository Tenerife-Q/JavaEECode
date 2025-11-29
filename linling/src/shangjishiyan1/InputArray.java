package shangjishiyan1;

public class InputArray {
   public static void main (String args[ ]) {
      int [] a = {100,200,300};
      
      // 输出数组a的长度
      System.out.println("数组a的长度: " + a.length);       
      
      // 输出数组a的引用
      System.out.println("数组a的引用: " + a);
      
      int b[][]= {{1}, {1,1},{1,2,1}, {1,3,3,1},{1,4,6,4,1}};
      
      // 输出二维数组b的一维数组的个数
      System.out.println("数组b的长度: " + b.length);
      
      System.out.println("b[4][2]的原始值: " + b[4][2]);
      
      //将数组a的引用赋给b[4]
      b[4] = a;
      
      System.out.println("b[4][2]的当前值: " + b[4][2]);
   }
}