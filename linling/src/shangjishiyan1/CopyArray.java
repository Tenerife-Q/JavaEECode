package shangjishiyan1;

import java.util.Arrays;
public class CopyArray {
   public static void main (String args[ ]) {
      int [] a = {1,2,3,4,500,600,700,800};
      int [] b,c,d;
      
      System.out.println("原始数组a: " + Arrays.toString(a));
      
      b = Arrays.copyOf(a,a.length);
      System.out.println("完整复制到b: " + Arrays.toString(b)); 
      
      //Arrays调用copyOf方法复制数组a的前4个元素 
      c = Arrays.copyOf(a, 4);
      
      //Arrays调用toString方法返回数组c元素值的字符串
      System.out.println("复制a前4个元素到c: " + Arrays.toString(c)); 
      
      //Arrays调用copyOfRange方法复制数组a的后4个元素
      d = Arrays.copyOfRange(a, 4, a.length);
      System.out.println("复制a后4个元素到d: " + Arrays.toString(d));
      
      //将-100赋给数组c的最后一个元素
      c[c.length-1] = -100;
      d[d.length-1] = -200;
      
      System.out.println("修改c和d后，c为: " + Arrays.toString(c));
      System.out.println("修改c和d后，d为: " + Arrays.toString(d));
      System.out.println("修改c和d后，原始数组a: " + Arrays.toString(a));
   }
}